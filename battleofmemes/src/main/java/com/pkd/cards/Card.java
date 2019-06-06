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

    public Card(String name){
        this.name = name;
        attributes = new TreeMap<>();
        attributesArray = new ArrayList<String>();
    }

    public SortedMap<String, Integer> getAllCardAttributesValues() {
        return this.attributes;
    }

    public int getValueOfAttribute(String attribute){
        return this.attributes.get(attribute);
    }

    private ArrayList<String> makeArrayFromAttributesMap(){
        ArrayList<String> keyList = new ArrayList<String>(this.attributes.keySet());
        ArrayList<Integer> valueList = new ArrayList<Integer>(this.attributes.values());
        ArrayList<String> attributesArray = new ArrayList<String>();
        int keysNumber = keyList.size();
        for (int i = 0; i <keysNumber; i++) {
            attributesArray.add(keyList.get(i) + ": " + valueList.get(i));
            attributesKeyArray.add(keyList.get(i));
            attributesValueArray.add(valueList.get(i));
        }
        return attributesArray;
    }

    public String getAttributesByNumberInString(int i){
        return attributesArray.get(i);

    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }

    public void addAttribute(String key, int value){
        this.attributes.put(key, value);
        this.attributesArray.add(key + ": " + value);
        this.attributesKeyArray.add(key);
        this.attributesValueArray.add(value);
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getNumberOfAttributes(){
        return attributes.size();
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