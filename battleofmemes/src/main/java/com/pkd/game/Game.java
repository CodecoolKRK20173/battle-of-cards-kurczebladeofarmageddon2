package com.pkd.game;

import com.pkd.DAO.ParseXml;
import com.pkd.cards.Card;
import com.pkd.cards.Cardlist;
import com.pkd.cards.Deck;
import com.pkd.visual.cardsVisual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
	private cardsVisual show = new cardsVisual ( );

	private ArrayList<Player> players = new ArrayList<> ( );
	//    private LinkedList<Card> temporaryList= new LinkedList<>();
//    private Deck temporaryDeck = new Deck(temporaryList);
	private Player temporaryPLayer = new Player (new Deck (new LinkedList<> ( )), "temporary player");

	public void startGame() {
		show.clearScreen ( );
		show.gameStart ( );
		try {
			System.in.read ( );

		} catch (IOException e) {
			e.printStackTrace ( );
		}
		show.clearScreen ( );
		gameInitiation ( );
		gameRounds (0);

	}

	private void gameInitiation() {
		Cardlist cardlist = new Cardlist (ParseXml.parseXML ( ));
		ArrayList<LinkedList<Card>> decks = cardlist.splitCardsOn (2);

		Deck player1Deck = new Deck (decks.get (0));
		Deck player2Deck = new Deck (decks.get (1));


		Player player1 = new Player (player1Deck, "Player 1");
		Player player2 = new Player (player2Deck, "Player 2");
		players.add (player1);
		players.add (player2);

	}

	private void gameRounds(int startingPlayer) {
		int activePlayer = startingPlayer;
		while (gameContinues (players)) {
//			System.out.println (gameContinues (players));
			activePlayer = turnActivePlayer (activePlayer);
		}

		show.printWinner (players.get (activePlayer));


	}

	private boolean gameContinues(ArrayList<Player> players) {
		return !playersEliminated (players);
	}

	private int turnActivePlayer(int i) {
		Player activePlayer = players.get (i);
		Player opponentPlayer = players.get (i == 0 ? 1 : 0);
		Card topCard = activePlayer.getTopCard ( );
		show.printPlayerRound (activePlayer);
		int chosenAttribute = activePlayer.choseCardAttribute (topCard);
		int activeAttributeValue = activePlayer.getTopCardAttribute (chosenAttribute);
		int opponentAttributeValue = opponentPlayer.getTopCardAttribute (chosenAttribute);
		show.clearScreen ( );

		int winnerIndex = players.indexOf (activePlayer);

//        show.printAllTopCard(this.players);
		boolean drawResult = (activeAttributeValue == opponentAttributeValue);
		if (drawResult) {
			addCardsToTemporaryPlayerDeck (activePlayer, opponentPlayer, temporaryPLayer);
            show.printDrawResume (activePlayer, opponentPlayer, temporaryPLayer, players, chosenAttribute);
            try {
				show.pause ( );
				System.in.read ( );
			} catch (IOException e) {
				e.printStackTrace ( );
			}
			show.clearScreen ( );
		} else {

			Player winner = activeAttributeValue > opponentAttributeValue ? activePlayer : opponentPlayer;
			Player looser = activeAttributeValue > opponentAttributeValue ? opponentPlayer : activePlayer;
			show.printClashResume (players, winner, temporaryPLayer, chosenAttribute);
			try {
				show.pause ( );
				System.in.read ( );
			} catch (IOException e) {
				e.printStackTrace ( );
			}
			show.clearScreen ( );
			winnerIndex = players.indexOf (winner);

			winner.wonCard (looser.getTopCard ( ));
			while (!temporaryPLayer.isDeckEmpty ( )) {
				for (int j = 0; j < temporaryPLayer.getDeckSize ( ); j++) {
					winner.wonCard (temporaryPLayer.getTopCard ( ));
					temporaryPLayer.loseTopCard ( );
				}
			}
			looser.loseTopCard ( );
		}
		return winnerIndex;
	}

	private boolean playersEliminated(ArrayList<Player> gamers) {
		int activePlayers = 0;
		for (Player player : gamers
		) {
			if (!player.isDeckEmpty ( )) activePlayers++;
		}
		return activePlayers <= 1;
	}

	private void addCardsToTemporaryPlayerDeck(Player activePlayer, Player opponentPlayer, Player temporaryPlayer) {


		temporaryPlayer.wonCard (activePlayer.getTopCard ( ));
		temporaryPlayer.wonCard (opponentPlayer.getTopCard ( ));
		activePlayer.loseTopCard ( );
		opponentPlayer.loseTopCard ( );
	}

}
