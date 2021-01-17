package collections.Hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class HashmapBasics {
    /*  Hashmap : is an associative array data structure
    -> Associative arrays are also called as Map/Symbol table/Dictionary, which is an abstract data type
     (a data type which is defined by its behavior), and it is a collection of (key, value) pairs and each key
      here appears at most once
    -> does not maintain any order.
    -> stores values -- key-Value <k,v>
    ->Hashmap does not contain duplicate key if you do so with different value but same key then
     it will give the latest response london got overridden with London11
    -> can store n number of null values but only one null key
    -> Hashmap is not thread-safe - un-synchronized (ConcurrentHashmap - synchronized)
    ->*** To iterate Hashmap we have entrySet.iterator(), value.iterator, key.iterator()
    -> ****public static interface Map.Entry<K,V>
            A map entry (key-value pair). The Map.entrySet method returns a collection-view of the map, whose elements are of this class.
            The only way to obtain a reference to a map entry is from the iterator of this collection-view. These Map.Entry objects are
            valid only for the duration of the iteration; more formally, the behavior of a map entry is undefined if the backing map has
            been modified after the entry was returned by the iterator, except through the setValue operation on the map entry.
    -> public interface BiConsumer<T,U>
        Represents an operation that accepts two input arguments and returns no result.
        This is the two-arity specialization of Consumer. Unlike most other functional interfaces,
        BiConsumer is expected to operate via side-effects.


     */

    public static void main(String h[]){
        HashMap<String, String> capitalMap = new HashMap<String, String>();
        capitalMap.put("India", "New Delhi");
        capitalMap.put("USA", "Washington DC");
        capitalMap.put("UK", "London");
        capitalMap.put("UK", "London11");
        capitalMap.put(null, "Berlin");
        capitalMap.put(null, "LA");
        capitalMap.put("Russia", null);
        capitalMap.put("France", null);
        capitalMap.remove("France");

        System.out.println(capitalMap.get("USA"));
        System.out.println(capitalMap.get("India"));
        System.out.println(capitalMap.get("Germany"));// if you don't have the key you will get null value
        System.out.println(capitalMap.get("UK"));
        //**** Remember - It will not give error instead it will give the latest response london got overridden with London11
        System.out.println(capitalMap.get(null));
        //**** Remember - Overriding Concept Again!!
        // It will not give error instead it will give the latest response if you try to pass more than one null key
        System.out.println(capitalMap.get("France")); //-> will obtain null
        System.out.println(capitalMap.get("Russia"));//-> will obtain null


        //iterator : iterating only for Keys using keySet()
        Iterator it = capitalMap.keySet().iterator(); //We will not directly iterate the HashMap because there is no iterator method to directly iterate it with
        //  instead use KeySet - returns the set of keys
        while(it.hasNext()){
            String key = (String) it.next();
            String value = capitalMap.get(key);// according to key we are storing values
            System.out.println("key = " + key + " || value = "+ value);
        }

        System.out.println("******************************************");

        //iterator : over the set (pair): by using entrySet
        Iterator<Map.Entry<String,String>> iter = capitalMap.entrySet().iterator();

        while (iter.hasNext()){
            Map.Entry<String,String> entry = iter.next();
            System.out.println("key = "+ entry.getKey() + " and value = " + entry.getValue());
        }

        System.out.println("==========================================");

        //iterate hashmap using java 8 for each and lambda:
        capitalMap.forEach( (key, value) -> { System.out.println( "Key: " + key + "\t" + " Value: " + value ); });


    }
}
