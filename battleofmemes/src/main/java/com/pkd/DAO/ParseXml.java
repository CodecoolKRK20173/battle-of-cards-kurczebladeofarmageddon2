package com.pkd.DAO;

import com.pkd.cards.Card;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.LinkedList;

public class ParseXml {

    public static LinkedList<Card> parseXML() {

        LinkedList<Card> cardList = new LinkedList<>();

        try {
            File inputFile = new File("battleofmemes/src/main/java/com/pkd/resources/Cards.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList factList = doc.getElementsByTagName("Card");

            for (int temp = 0; temp < factList.getLength(); temp++) {
                Node factNode = factList.item(temp);

                if (factNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) factNode;
                    NodeList descriptionList = eElement.getElementsByTagName("Description");
                    Card card = new Card (eElement.getAttribute ("name"));           //<-------------------------------------------Make new card (name of card)

                    for (int tempp = 0; tempp < descriptionList.getLength(); tempp++) {
                        Node descriptionNode = descriptionList.item(tempp);

                        if (descriptionNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eeElement = (Element) descriptionNode;
                            NodeList evalsList = eElement.getElementsByTagName("Attributes");
                            card.setDescription (eeElement.getAttribute ("value"));              //<-------------------------------------------Set card description

                            for (int cooun = 0; cooun < evalsList.getLength(); cooun++) {
                                Node evalsNode = evalsList.item(cooun);

                                if (evalsNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element eeeElement = (Element) evalsNode;
                                    NodeList evalList = eeeElement.getElementsByTagName("Attribute");

                                    for (int temps = 0; temps < evalList.getLength(); temps++) {
                                        Node node1 = evalList.item(temps);

                                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                                            Element car = (Element) node1;
                                            card.addAttribute (car.getAttribute ("id"),Integer.parseInt (car.getTextContent ()));      //<----- Add Card attrobute ( attribute id, attribute value)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    cardList.add (card);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    return cardList;
    }
}