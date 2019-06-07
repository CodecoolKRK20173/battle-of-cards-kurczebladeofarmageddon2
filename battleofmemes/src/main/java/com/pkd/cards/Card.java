package com.pkd.cards;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class Card {
    private final String name;
    private String description;
    private SortedMap<String, Integer> attributes;
    private ArrayList<String> attributesArray;
    private ArrayList<String> attributesKeyArray;
    private ArrayList<Integer> attributesValueArray;

    public Card(String name) {
        this.name = name;
        this.attributes = new TreeMap<> ( );
        this.attributesArray = new ArrayList<String> ( );
        this.attributesKeyArray = new ArrayList<String> ( );
        this.attributesValueArray = new ArrayList<Integer> ( );
    }

    public SortedMap<String, Integer> getAllCardAttributesValues() {
        return this.attributes;
    }

    public int getValueOfAttribute(String attribute) {
        return this.attributes.get (attribute);
    }

    public String getAttributesKeyByNumberInString(int i) {
        return attributesKeyArray.get (i);

    }

    public String getAttributesByNumberInString(int i) {
        return attributesArray.get (i);

    }

    public void addAttribute(String key, int value) {
        this.attributes.put (key, value);
        this.attributesArray.add (key + ": " + value);
        makeArrayFromAttributesMap ( );
    }

    private ArrayList<String> makeArrayFromAttributesMap() {
        ArrayList<String> keyList = new ArrayList<String> (this.attributes.keySet ( ));
        ArrayList<Integer> valueList = new ArrayList<Integer> (this.attributes.values ( ));
        ArrayList<String> attributesArray = new ArrayList<String> ( );
        int keysNumber = keyList.size ( );
        attributesKeyArray.clear ( );
        attributesValueArray.clear ( );
        for (int i = 0; i < keysNumber; i++) {
            attributesArray.add (keyList.get (i) + ": " + valueList.get (i));
            attributesKeyArray.add (keyList.get (i));
            attributesValueArray.add (valueList.get (i));
        }
        return attributesArray;
    }

    public int getNumberOfAttributes() {
        return attributes.size ( );
    }

    public int hashCode() {
        String result = "";
        for (String key : this.attributes.keySet ( )) {
            result += attributes.get (key) + "00";
        }
        int hash = Integer.parseInt (result, 10);
        return hash;
    }

    @Override
    public String toString() {
        String output = "";
        output += "Meme: " + this.getName ( ) + "\n";
        output += "Story: " + this.getDescription ( ) + "\n";
        int numb = 1;
        for (String key : this.attributes.keySet ( )
        ) {
            output += numb + ":  " + key + ": " + this.attributes.get (key) + "\n";
            numb++;
        }
//        output += String.valueOf(this.hashCode());
        return output;
    }

    public String getName() {
        return this.name;
    }


    public ArrayList<String> getAttributesKeyArray() {
        return attributesKeyArray;
    }

    public ArrayList<Integer> getAttributesValueArray() {
        return attributesValueArray;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}