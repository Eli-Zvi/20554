/**
 * Student Name: Ilay Zvi
 *  Date: 19/1/2023
 *  Class Name: PhoneBook
 */
package com.example.mamman14q2;

import java.util.TreeMap;

public class PhoneBook{

    private TreeMap<String,String> table; //table key = (String) name, value = String(Phone Number)

    public PhoneBook()
    {
        table = new TreeMap<>();
    }

    /**
     * add entry consisting of name as the key and associated value phone number to table
     * @param key - name to be associated with phone number
     * @param value - phone number to be associated with name
     * @throws IllegalArgumentException name is in the table or illegal name/phone number
     */
    public void add(String key, String value) throws IllegalArgumentException
    {
        if(!table.containsKey(key) && validateName(key) && validateNumber(value))
            table.put(key,value);
        else throw new IllegalArgumentException("Name already exists in phone book or number is illegal");
    }

    /**
     * Remove entry from table
     * @param key - entry to remove
     * @return true if removal done successfully
     */
    public boolean remove(String key)
    {
        return table.remove(key) != null;
    }

    /**
     * Returns phone number associated with name
     * @param key - name mapped to a number
     * @return phone number associated with name if it exists
     */
    public String get(String key)
    {
        return table.get(key);
    }

    /**
     * Updates the phone number associated with the given name(key)
     * @param key - a name to update the phone number of
     * @param value - the new phone number
     * @throws IllegalArgumentException - if the name does not exist in the table or the phone number is illegal
     */
    public void update(String key, String value) throws IllegalArgumentException
    {
        if(table.containsKey(key) && validateNumber(value))
        {
            remove(key);
            add(key,value);
        } else throw new IllegalArgumentException("Name does not exist in the table or number is illegal");
    }

    /**
     * Searches the table for the name(key) parameter
     * @param name - name to find the phone number of if it exists
     * @return a map instance with only the entry or an empty map
     */
    public TreeMap<String,String> search(String name)
    {
        TreeMap<String,String> resultMap = new TreeMap<>();

        if(table.containsKey(name)) {
            resultMap.put(name,table.get(name));
            return resultMap;
        }
        return resultMap;
    }

    /**
     * validates that the phone number is of length 10 and contains only numbers
     * @param number phone number to be validated
     * @return True if number is valid false otherwise
     */
    private boolean validateNumber(String number)
    {
        return number.length() == 10 && number.matches("\\d+");
    }

    /**
     * Checks that the name contains only letters and spaces
     * @param name - name to be checked
     * @return true if the conditions are met
     */
    private boolean validateName(String name)
    {
        return name.matches("[ a-zA-Z]+");
    }

    /**
     * @return treemap with names as keys and phone numbers as values
     */
    public TreeMap<String,String> getTable()
    {
        return this.table;
    }
}
