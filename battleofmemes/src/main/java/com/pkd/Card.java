package com.pkd;

import java.util.SortedMap;
import java.util.TreeMap;

public class Card {
    private final String name;
    private SortedMap<String, Integer> attributes; 

    public Card(String name){
        this.name = name;
        attributes = new TreeMap<>(); 
    }

    public SortedMap<String, Integer> getAllCardAttributesValues() {
        return this.attributes;
    }

    public int getValueOfAttribute(String attribute){
        return this.attributes.get(attribute);
    }

    public void addAttribute(String key, int value){
        this.attributes.put(key, value);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        String result = "";
        for (String key : this.attributes.keySet()) {
            result += attributes.get(key) + "0000";
        }
        return Integer.parseInt(result);
    }
}