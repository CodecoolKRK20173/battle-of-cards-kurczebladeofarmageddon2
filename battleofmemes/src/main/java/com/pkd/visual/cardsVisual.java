package com.pkd.visual;

import com.pkd.game.Player;

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
        for (Player player: players
        ) {
            System.out.print(String.format("| %28s|",player.getTopCard().getDescription()));
        }
    }

    public int getMaxAttributesOfTopCard(ArrayList<Player> players){
        int i = 0;
        for (Player player: players
             ) {
            if(player.getTopCard().getNumberOfAttributes()>i) i = player.getTopCard().getNumberOfAttributes();
        }
        return i;
    }
}
