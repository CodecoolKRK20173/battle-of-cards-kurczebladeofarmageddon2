package com.pkd.cards;

import java.util.SortedMap;
import java.util.TreeMap;

public class Card {
    private final String name;
    private String description;
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
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }

    public void addAttribute(String key, int value){
        this.attributes.put(key, value);
    }

    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public String toString(){
        String output = "";
        output += "Meme: " + this.getName() + "\n";
        output += "Story: " + this.getDescription() + "\n";
        for (String key : this.attributes.keySet()
             ) { output += key + ": " + this.attributes.get(key) + "\n";
        }
//        output += String.valueOf(this.hashCode());
        return output;
    }


    public int hashCode() {
        String result = "";
        for (String key : this.attributes.keySet()) {
            result += attributes.get(key) + "00";
        }
        int hash = Integer.parseInt(result, 10);
        return hash;
}}