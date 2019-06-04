package com.pkd;

import java.util.SortedMap;
import java.util.TreeMap;

public class Card {
    private SortedMap<String, Integer> attributes; 

    public Card(){
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

    @Override
    public int hashCode() {
        String result = "";
        for (String key : this.attributes.keySet()) {
            result += attributes.get(key) + "0000";
        }
        return Integer.parseInt(result);
    }
}