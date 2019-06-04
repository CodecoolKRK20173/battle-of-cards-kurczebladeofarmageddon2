package com.pkd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Cardlist {
    private LinkedList<Card> cardList;

    public Cardlist(){
        this.cardList = new LinkedList<>();
    }

    public void addcard(Card card){
        cardList.add(card);
    }

    public ArrayList<LinkedList<Card>> splitCardsOn(int numbersOfDecs){
        ArrayList<LinkedList<Card>> decks = new ArrayList<LinkedList<Card>>();
        int numberOfCards = cardList.size();
        int lastDeckIndex = numbersOfDecs - 1;
        LinkedList<Card> shuffeledCards = new LinkedList<Card>(this.cardList);
        Collections.shuffle(shuffeledCards);
        for (int j = 0; j < numbersOfDecs; j++)
            decks.add(new LinkedList<Card>());

        int j = 0;
        for (int i = 0; i<numberOfCards; i ++){
            decks.get(j).add(shuffeledCards.get(i));
            j++;
            if (j>lastDeckIndex) j = 0;
        }
        return decks;
    }
}