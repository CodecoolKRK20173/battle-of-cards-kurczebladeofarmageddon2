package com.pkd.visual;

import com.pkd.cards.Cardlist;
import com.pkd.game.Player;
import com.pkd.cards.Card;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.String.format;

public class cardsVisual {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void gameStart(){
        System.out.println("Long time ago an evil entity stole all jokes of the world.");
        System.out.println("Jokes were gathered in "+ANSI_RED+"\"The Arena\""+ANSI_RESET+" - place hidden in time and space.");
        System.out.println("And where ordered to fight.");
        System.out.println("Till dead.");
    }

    public void printClashResume(ArrayList<Player> players, Player winner, Player temporaryPlayer, int selectedAttribute){
        printAllTopCard(players, selectedAttribute, winner);
        System.out.println(ANSI_GREEN + "Winning player: " + winner.getName()+ ANSI_RESET);
        int numberOfCards = temporaryPlayer.getDeckSize() + players.size()-1;
        System.out.println(ANSI_BLUE + "Number of cards won: " + numberOfCards +"\n" + ANSI_RESET);
    }

    public void printDrawResume(Player activePlayer, Player opponentPlayer, Player temporaryPlayer, ArrayList<Player> players, int selectedAttribute){
        printAllTopCard(players, selectedAttribute, temporaryPlayer);
        System.out.println("It was DRAW! You will fight to win drawed cards in next round.");
        System.out.println("Drawed cards = "+temporaryPlayer.getDeckSize());
        System.out.println("Active Player cards = "+activePlayer.getDeckSize());
        System.out.println("Opponent Player cards = "+opponentPlayer.getDeckSize());
        System.out.println("Choose carefully your next comparing attribute :) \n");
    }

    public void pause(){
        System.out.println("Press any key to continue.");
    }

    public void printAllTopCard(ArrayList<Player> players, int selectedAttribute, Player winner){

        System.out.println("┌─────────────────────────────┐┌─────────────────────────────┐");
        for (Player player: players
             ) {
            System.out.print(String.format(player==winner ? ("│"+ANSI_GREEN+" Player: %-20s"+ANSI_RESET+"│") : ("│ Player: %-20s│"), player.getName()));
        }
        System.out.println("");
        for (Player player: players
        ) {
            System.out.print(String.format("│ Deck size: %-17d│", player.getDeckSize()));
        }
        System.out.println("");
        System.out.println("├─────────────────────────────┤├─────────────────────────────┤");
        for (Player player: players
        ) {
            System.out.print(String.format("│ %28s│", player.getTopCard().getName()));
        }
        System.out.println("");
        int maxAttributes = getMaxAttributesOfTopCard(players);
        for(int i = 0; i < maxAttributes; i++){
            for (Player player: players
            ) {
                System.out.print(String.format(i==selectedAttribute ? ("│"+ANSI_RED+" %-28s"+ANSI_RESET+"│") : ("│ %-28s│"),String.valueOf(i+1) + ". " + player.getTopCard().getAttributesKeyByNumberInString(i) + " = " + player.getTopCard().getAttributesValueArray().get(i)));
            }
            System.out.println("");
        }
        System.out.println("└─────────────────────────────┘└─────────────────────────────┘");
        System.out.println("");
    }

    public void printSingleCard(Card card){
        int numberOfAttributes = card.getNumberOfAttributes();
        ArrayList<String> keyList = card.getAttributesKeyArray();
        ArrayList<Integer> valueList = card.getAttributesValueArray();

        System.out.println("├─────────────────────────────┤");
        System.out.println(String.format("│ %28s│", card.getName()));
        for (int i = 0; i<numberOfAttributes; i++){
            System.out.println(String.format("│ %-28s│",String.valueOf(i+1) + ". " + keyList.get(i) + " = " + String.valueOf(valueList.get(i))));
        }
        System.out.println("└─────────────────────────────┘");
        System.out.println("Text: " + card.getDescription());

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
        System.out.print("\nSelect attribute number: ");
    }

    public void printPlayerRound(Player player){
        System.out.println("┌─────────────────────────────┐");
        System.out.println(String.format("│ "+ANSI_GREEN+"Active player: %-13s" + ANSI_RESET+"│" , player.getName()));
        System.out.println(String.format("│ Deck size: %-17d│", player.getDeckSize()));
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

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }

    }

    public void printWinner(Player player) {
        System.out.println("Winner: " + ANSI_GREEN + player.getName());
    }
}
