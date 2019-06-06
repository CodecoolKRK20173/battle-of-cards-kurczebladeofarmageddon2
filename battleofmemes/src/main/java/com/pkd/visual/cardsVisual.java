package com.pkd.visual;

import com.pkd.cards.Cardlist;
import com.pkd.game.Player;
import com.pkd.cards.Card;

import java.util.ArrayList;

import static java.lang.String.format;

public class cardsVisual {
    public void printAllTopCard(ArrayList<Player> players){
        for (Player player: players
             ) {
            System.out.print(String.format("| Player: %-20s|", player.getName()));
        }
        System.out.println("");
        for (Player player: players
        ) {
            System.out.print(String.format("| %28s|", player.getTopCard().getName()));
        }
        System.out.println("");
        int maxAttributes = getMaxAttributesOfTopCard(players);
        for(int i = 0; i < maxAttributes; i++){
            for (Player player: players
            ) {
                System.out.print(String.format("| %-28s|",String.valueOf(i+1) + ". " + player.getTopCard().getAttributesByNumberInString(i)));
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void printSingleCard(Card card){
        int numberOfAttributes = card.getNumberOfAttributes();
        ArrayList<String> keyList = card.getAttributesKeyArray();
        ArrayList<Integer> valueList = card.getAttributesValueArray();

        System.out.println(card.getName());
        for (int i = 0; i<numberOfAttributes; i++){
            System.out.println(keyList.get(i) + ": " + valueList.get(i));
        }
        System.out.println(card.getDescription());

    }

    public void printPlayerDeck(Player player){
        printCardlist(player.getDeck());
    }

    public void printCardlist(Cardlist list){
        System.out.println(list.toString());
    }

    public void printString(String string){
        System.out.println(string);
    }

    public void printPlayerName(Player player){
        System.out.println(player.getName());
    }

    public void printAttributeChoseInputPrompt(){
        System.out.print("Select attribute: ");
    }

    public void printPlayerRound(Player player){
        printPlayerName(player);
        printSingleCard(player.getTopCard());
        printAttributeChoseInputPrompt();

    }

    private int getMaxAttributesOfTopCard(ArrayList<Player> players){
        int i = 0;
        for (Player player: players
             ) {
            if(player.getTopCard().getNumberOfAttributes()>i) i = player.getTopCard().getNumberOfAttributes();
        }
        return i;
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
