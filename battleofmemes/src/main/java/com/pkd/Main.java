package com.pkd;
import com.pkd.DAO.ParseXml;
import com.pkd.cards.*;

public class Main {
    public static void main(String[] args) {
        Cardlist cardlist = new Cardlist (ParseXml.parseXML ());
        System.out.println (cardlist.toString());



    }
}
