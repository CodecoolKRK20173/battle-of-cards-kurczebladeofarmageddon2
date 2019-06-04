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
//            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList factList = doc.getElementsByTagName("Card");

            System.out.println("----------------------------" +factList.getLength() );


            for (int temp = 0; temp < factList.getLength(); temp++) {
                        Node factNode = factList.item(temp);
                        //System.out.println("\n<Fact>" + factNode.getNodeName()); // <Fact>
//                        System.out.println("\n");

                if (factNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) factNode;
//                    System.out.println("<Card id=> "
//                       + eElement.getAttribute("name"));


                    Card card = new Card (eElement.getAttribute ("name"));


                    NodeList descriptionList = eElement.getElementsByTagName("Description");

                   for (int tempp = 0; tempp < descriptionList.getLength(); tempp++) {
                    Node descriptionNode = descriptionList.item(tempp);
    
//                    Node descriptionNode = descriptionList.item(temp);


                    if (descriptionNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eeElement = (Element) descriptionNode;
                        //System.out.println("Fact Element: " + descriptionNode.getNodeName());
//                        System.out.println("<Description value=>" //<Description value=>
//                            + eeElement.getAttribute("value"));

                        card.setDescription (eeElement.getAttribute ("value"));
                        NodeList evalsList = eElement.getElementsByTagName("Attributes");
//                        Node evalsNode = evalsList.item(temp);

                        for (int cooun = 0; cooun < evalsList.getLength(); cooun++) {
                        Node evalsNode = evalsList.item(cooun);


                        if (evalsNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eeeElement = (Element) evalsNode;
//                            System.out.println("<"+ evalsNode.getNodeName()+">"); //<Evals>
                            NodeList evalList = eeeElement.getElementsByTagName("Attribute");


                            
                            for (int temps = 0; temps < evalList.getLength(); temps++) {
                            Node node1 = evalList.item(temps);
                                
                                if (node1.getNodeType() == node1.ELEMENT_NODE) {
                                    Element car = (Element) node1;
//                                    System.out.print("Attribute id =");
//                                    System.out.println(car.getAttribute("id")); // family/money/comfort
//                                    System.out.print("Value "+ car.getAttribute("id")+" ="); //Value family/money/... =
//                                    System.out.println(car.getTextContent()); //boolean
                                    card.addAttribute (car.getAttribute ("id"),Integer.parseInt (car.getTextContent ()));


                                }
                            }

                        }
                        
                    }
                }
            }
                    cardList.add (card);
        }
            }


        } catch (Exception e) {
            e.printStackTrace();
         }



    


    return cardList;
    }
}