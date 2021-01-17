package collections.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashmapHashingTechnique {
    public  static void main(String t[]){
        Map<String, Integer> marks = new HashMap<String, Integer>() ;
        marks.put("Sakshi",100);
        marks.put("Nikhil", 96);
        marks.put("Barry",89);
        marks.put("op", 68);
        marks.put(null, 700);
        marks.put("op", 68);

        //hashing : hashcode() --> hashing method comes from object class.
        // whenever we make a hashmap a 16 bucket/nodes are created
        // buckets behave as node maintains, 1 hash, 1 key, 1 value, 1 pointer.
        //One node consists of key, hashcode, value, next pointer.
        //put method = internally calculates the hashcode & then the index to locate it on nodes(array)
        //once the index is filled with one node and other key obtains the same index then
        // linkedlist connection comes into play
        //suppose two keys obtains the same index 2 then one node points to the new node instead of pointing to null
        //This condition of storing multiple keys at same index in the hashmap is called ||collision||
        //$$$ Multiple objects can have same hashcode
        //while fetching using get method it first calculates he hashcode of the key and then goes to index to get value
        //If 2 different keys have same index = 4 then it first matches on the basis of hashcode and even if hashcodes are same
        //then it searches for key via .equals()method
        //hashcode() & equals() methods are compliment to each other.
        //hashcode of null key is always 0, index also will be 0
        // 8 nodes of linked list are connected it will yield O(n) complexity while we traverse linearly
        //As an improvement when nodes reaches threshold value of 8 then using some mechanism linkedlist
        //gets converted into Balanced tree reducing worst case complexity from O(n) to O(log n)

        System.out.println("Sakshi");

        //hashcode of sakshi ---183884764
        //index = 7
        //.equals to check the key name
        //Sakshi
        //return value


    }
}
