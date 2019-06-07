package com.pkd.game;

import com.pkd.cards.Card;
import com.pkd.cards.Deck;

import java.util.Scanner;

public class Player {

    private Deck deck;
    private final String name;

    Player(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
    }

    void loseTopCard() {
        deck.removeTopCard ( );
    }

    void wonCard(Card card) {
        deck.moveTopCardToBottom ( );
        deck.addNewCard (card);
    }

    public Card getTopCard() {
        return deck.getTopCard ( );
    }

    boolean isDeckEmpty() {
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


    int choseCardAttribute(Card card) {
        int idx = 1;
        boolean isRunning = true;
        while (isRunning) {
            Scanner inp = new Scanner (System.in);
            int input = inp.nextInt ( );
            idx = input - 1;
            if (input > 0 && input <= this.deck.getTopCard ( ).getNumberOfAttributes ( )) isRunning = false;
        }
        return idx;
    }

    int getTopCardAttribute(int attribute) {
        Card card = getTopCard ( );
        String keyS = card.getAttributesKeyByNumberInString (attribute);

        return card.getValueOfAttribute (keyS);
    }

    public String getName() {
        return this.name;
    }


}
