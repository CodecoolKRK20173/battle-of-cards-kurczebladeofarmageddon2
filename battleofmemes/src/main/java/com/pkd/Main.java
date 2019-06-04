package com.pkd;
import com.pkd.cards.*;

public class Main {
    public static void main(String[] args) {
        Card testCard = new Card("OHYEAHMEME");
        testCard.setDescription("10hours looped meme!");
        testCard.addAttribute("Fun", 5);
        testCard.addAttribute("Fresh", 2);
        testCard.addAttribute("Dry", 3);
        testCard.addAttribute("Shame", 4);
        System.out.println(testCard.toString());

    }
}
