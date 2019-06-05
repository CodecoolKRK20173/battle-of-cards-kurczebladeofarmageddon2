package com.pkd.game;

import com.pkd.cards.Card;
import com.pkd.cards.Deck;

import java.util.Scanner;

public class Player {
    private Deck deck;

    public Player(Deck deck){
        this.deck = deck;
    }

    public void loseTopCard(){
        deck.removeTopCard();
    }

    public void wonCard(Card card) {
        deck.moveTopCardToBottom();
        deck.addNewCard(card);
    }

    public Card getTopCard(){
        return deck.getTopCard();
    }

    public boolean isDeckEmpty(){
        return deck.isEmpty();
    }
    public String showDeck(){
        return deck.toString();

    }



    public String chooseCardAttribute(Card card) {
        Scanner inp = new Scanner(System.in);
        String input = inp.nextLine();
        return input;

    }

    public int getTopCardAttribute(String attribute){
        Card card = getTopCard();
        return card.getValueOfAttribute(attribute);
    }
}
