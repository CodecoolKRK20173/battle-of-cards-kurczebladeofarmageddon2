package com.pkd;

import java.util.ArrayList;
import java.util.LinkedList;

public class Cardlist {
    private LinkedList<Card> cardList;
    public Cardlist(){
        this.cardList = new LinkedList<>();
    }

    public void addcard(Card card){
        cardList.add(card);
    }

    // public ArrayList<LinkedList<Card>> splitCardsOn(int numbersOfDecs){
    //     ArrayList<LinkedList<Card>> decks = new ArrayList<LinkedList<Card>>();
    //     int numberOfCards = cardList.size();
        // TODO
    // }
}