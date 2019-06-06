package com.pkd.game;

import com.pkd.cards.Card;
import com.pkd.cards.Deck;

import java.util.Scanner;
import java.util.Set;

public class Player {

    private Deck deck;
    private final String name;

    public Player(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
    }

    public void loseTopCard() {
        deck.removeTopCard ( );
    }

    public void wonCard(Card card) {
        deck.moveTopCardToBottom ( );
        deck.addNewCard (card);
    }

    public Card getTopCard() {
        return deck.getTopCard ( );
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty ( );
    }

    public String showDeck() {
        return "Player: " + this.name + "\n" + deck.toString ( );

    }

    public Deck getDeck() {
        return deck;
    }

    public int getDeckSize() {
        return this.deck.getSize ( );
    }


    public int choseCardAttribute(Card card) {
        int idx = 1;
        boolean isRunning = true;
        while (isRunning) {
            Scanner inp = new Scanner (System.in);
            int input = inp.nextInt ( );
            idx =input-1;
            if (input > 0 && input <= this.deck.getTopCard ().getNumberOfAttributes ()) isRunning = false;
        }
        return idx;
    }

    public int getTopCardAttribute(int attribute) {
        Card card = getTopCard ( );
        String keyS = card.getAttributesKeyByNumberInString (attribute);
        System.out.println (card.getAttributesKeyArray ( ));
        System.out.println (keyS);
        return card.getValueOfAttribute (keyS);
    }

    public String getName() {
        return this.name;
    }


}
