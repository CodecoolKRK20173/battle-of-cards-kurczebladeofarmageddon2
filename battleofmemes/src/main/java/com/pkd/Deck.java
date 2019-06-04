package com.pkd.cards;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> deck;
    
    public Deck(LinkedList<Card> deck){
        this.deck = deck;
    }

    public int getSize(){
        return deck.size();
    }

    public Card getTopCard(){
        return deck.getFirst();
    }

    public void removeTopCard(){
        this.deck.removeFirst();
    }

    public void addNewCard(Card card){
        this.deck.add(card);
    }

    public void moveTopCardToBottom(){
        if (deck.size()>0)
            deck.add(deck.remove(0));
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }
}