package com.pkd.cards;

import java.util.Collections;
import java.util.LinkedList;

public class Deck extends Cardlist{
    
    public Deck(LinkedList<Card> deck){
        super(deck);
    }

    public Card getTopCard(){
        return this.cardList.getFirst();
    }

    public void removeTopCard(){
        this.cardList.removeFirst();
    }

    public void addNewCard(Card card){
        this.cardList.add(card);
    }

    public void moveTopCardToBottom(){
        if (cardList.size()>0)
            cardList.add(cardList.remove(0));
    }

    public boolean isEmpty(){
        return this.cardList.isEmpty();
    }

    public void shuffle(){
        Collections.shuffle(this.cardList);
    }
}