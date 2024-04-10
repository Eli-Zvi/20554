/**
 * Student Name: Ilay Zvi
 *  ID: 324125657
 *  Date: 18/1/2023
 *  Class Name: AssociationTable.java
 */

import java.util.Iterator;
import java.util.TreeMap;

public class AssociationTable <K extends Comparable<K> ,V> {

    private TreeMap<K,V> table; //associative table

    //default constructor for associative table
    public AssociationTable()
    {
        table = new TreeMap<>(); //empty map
    }

    public AssociationTable(K[] keys, V[] values) throws IllegalArgumentException
    {
        if((keys.length == values.length)) //check that the number of keys = the number of values
        {
            table = new TreeMap<>(); //empty map

            for(int i = 0; i < keys.length;i++)
            {
                this.add(keys[i],values[i]); //add all keys and map all values
            }
        }
        else throw new IllegalArgumentException("Number of students is different to the number of grades given");
    }

    /**
     * adds and maps key to value
     * @param key key to map to value
     * @param value value that the key is mapped to
     */
    public void add(K key, V value)
    {
        table.put(key,value);
    }

    /**
     * returns value mapped to key if it exists
     * @param key the key that the value of we should receive
     * @return value V mapped by K or null if it doesn't exist
     */
    public V get(K key)
    {
        return table.get(key);
    }

    /**
     * returns if the key is in the table
     * @param key key to be checked
     * @return if the key is in the table or not
     */
    public boolean contains(K key)
    {
        return table.containsKey(key);
    }

    /**
     * removes key and its associated value from the table
     * @param key the key to be removed
     * @return if the key was successfully removed or not
     */
    public boolean remove(K key)
    {
        return table.remove(key) != null;
    }

    /**
     * @return the size of the table
     */
    public int size()
    {
        return table.size();
    }

    /**
     * @return key iterator
     */
    public Iterator<K> keyIterator()
    {
        return table.keySet().iterator();
    }

    /**
     * @return string representation of the keys and values in the table
     */
    public String toString()
    {
        Iterator<K> keyIterator = this.keyIterator();
        String result = "Student list and grades sorted according to ID\n\n";

        while(keyIterator.hasNext()) {
            K temp = keyIterator.next();
            result += temp + "\nStudent Average: " + get(temp) + "\n\n";
        }

        return result;
    }
}
