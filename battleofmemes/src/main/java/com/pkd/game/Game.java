package com.pkd.game;

import com.pkd.DAO.ParseXml;
import com.pkd.cards.Card;
import com.pkd.cards.Cardlist;
import com.pkd.cards.Deck;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void startGame() {
        gameInitiacion();
        System.out.println(players.get(0).showDeck());
        System.out.println(players.get(1).showDeck());
        turnActivePlayer(0);
        turnActivePlayer(1);
        System.out.println(players.get(0).showDeck());
        System.out.println(players.get(1).showDeck());

    }

    public void turnActivePlayer(int i){
        Player activePlayer = players.get(i);
        Player oponentPlayer = players.get(i == 0 ? 1 : 0);
        Card topCard = activePlayer.getTopCard();
        System.out.println(topCard.toString());
        String choosenAtribute = activePlayer.chooseCardAttribute(topCard);
        int activeAtributeValue = activePlayer.getTopCardAttribute(choosenAtribute);
        int opponentAtributeValue = oponentPlayer.getTopCardAttribute(choosenAtribute);

        Player winner = activeAtributeValue > opponentAtributeValue ? activePlayer : oponentPlayer;
        Player looser = activeAtributeValue > opponentAtributeValue ? oponentPlayer : activePlayer;
        winner.wonCard(looser.getTopCard());
        looser.loseTopCard();
    }




    public void gameInitiacion () {
        Cardlist cardlist = new Cardlist(ParseXml.parseXML());
        ArrayList<LinkedList<Card>> decks = cardlist.splitCardsOn(2);

        Deck player1Deck = new Deck(decks.get(0));
        Deck player2Deck = new Deck(decks.get(1));


        Player player1 = new Player(player1Deck);
        Player player2 = new Player(player2Deck);
        players.add(player1);
        players.add(player2);

//        System.out.println(player1.showDeck());
//        System.out.println("------------------------------------");
//        System.out.print(player2.showDeck());


    }

}
