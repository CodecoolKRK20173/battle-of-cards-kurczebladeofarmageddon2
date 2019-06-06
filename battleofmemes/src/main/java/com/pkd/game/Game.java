package com.pkd.game;

import com.pkd.DAO.ParseXml;
import com.pkd.cards.Card;
import com.pkd.cards.Cardlist;
import com.pkd.cards.Deck;
import com.pkd.visual.cardsVisual;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void startGame() {
        gameInitiacion();
        System.out.println(players.get(0).showDeck());
        System.out.println(players.get(1).showDeck());
        gameRounds(0);
        System.out.println(players.get(0).showDeck());
        System.out.println(players.get(1).showDeck());

    }

    public boolean opponentsEliminated(ArrayList<Player> gamers){
        int activePlayers = 0;
        for (Player player: gamers
             ) {if (!player.isDeckEmpty()) activePlayers++;
        }
        return activePlayers == 1;
    }

    public boolean gameContinues(ArrayList<Player> gamers){
        return !opponentsEliminated(gamers);
    }

    public void gameRounds(int startingPlayer){
        int activePlayer = startingPlayer;
        while (gameContinues(players)){
            activePlayer = turnActivePlayer(activePlayer);
        }


    }

    public int turnActivePlayer(int i){
        cardsVisual show = new cardsVisual();
        Player activePlayer = players.get(i);
        Player opponentPlayer = players.get(i == 0 ? 1 : 0);
        Card topCard = activePlayer.getTopCard();
        System.out.println("Current player: "+ activePlayer.getName());
        System.out.println("Deck size: " + activePlayer.getDeckSize());
        System.out.println(topCard.toString());
        String chosenAttribute = activePlayer.choseCardAttribute(topCard);
        show.printAllTopCard(players);
        int activeAttributeValue = activePlayer.getTopCardAttribute(chosenAttribute);
        int opponentAttributeValue = opponentPlayer.getTopCardAttribute(chosenAttribute);

        Player winner = activeAttributeValue > opponentAttributeValue ? activePlayer : opponentPlayer;
        Player looser = activeAttributeValue > opponentAttributeValue ? opponentPlayer : activePlayer;

        int winnerIndex = players.indexOf(winner);

        winner.wonCard(looser.getTopCard());
        looser.loseTopCard();
        return winnerIndex;
    }

    public void gameInitiacion () {
        Cardlist cardlist = new Cardlist(ParseXml.parseXML());
        ArrayList<LinkedList<Card>> decks = cardlist.splitCardsOn(2);

        Deck player1Deck = new Deck(decks.get(0));
        Deck player2Deck = new Deck(decks.get(1));


        Player player1 = new Player(player1Deck, "Player 1");
        Player player2 = new Player(player2Deck, "Player 2");
        players.add(player1);
        players.add(player2);

    }

}
