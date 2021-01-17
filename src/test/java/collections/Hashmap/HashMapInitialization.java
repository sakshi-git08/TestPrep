package collections.Hashmap;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapInitialization {

    public static Map<String, Integer> marksMap;//declared static Map

    static {
        marksMap = new HashMap<>(); // initializing the static map
        marksMap.put("A", 90);
        marksMap.put("B", 78);
        //since it is of static property hence we don't need to create the object of the class
        //generally we dont use static way as it creates one inner class which may lead to stackoverflow exception
        //in case of memory management
    }

    public static void main(String j[]) {

        // 1. using HashMap Class
        HashMap<String, String> map = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>(); // upcasting

        // 2. static way : static hashmap:
        HashMapInitialization.marksMap.get("A");
        System.out.println(HashMapInitialization.marksMap.get("A"));

        //Can we create one immutable map with only one single entry?

        //3. Singleton:
        Map<String, Integer> map3 = Collections.singletonMap("test", 100);
        /*singleton :
//        Returns an immutable set containing only the specified object. The returned set is serializable.
//
//                Type Parameters:
//        T - the class of the objects in the set
//                Parameters:
//        o - the sole object to be stored in the returned set.
//                Returns:
//        an immutable set containing only the specified object.

         */
        System.out.println(map3.get("test"));
        //map3.put("abc",300);// gives UnsupportedOperationException as it only takes one input which can't be altered at all.

        //4. JDK 8:

//        Map<String,Integer>map4 = Stream.of(new String[][]{
//                {"Tom", "A Grade"},
//                {"Jerry", "A+ Grade"},
//        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

        //5. using SimpleEntry: Immutable map
        Map<String, String> map5 = Stream.of(
                new AbstractMap.SimpleEntry<>("Sakshi","java"),
                new AbstractMap.SimpleEntry<>("fine","python")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map5.get("Sakshi"));
        map5.put("Shiva", "Javascript");
        System.out.println(map5.get("Shiva"));// here we can add multiple entries.

        //another way:
        Map<String, String> myMap = new HashMap<String, String>() {{
            put("a", "b");
            put("c", "d");
        }};

        //JDK 1.9:
        //empty Map:
//        Map<String, String> emptyMap = Map.of(); well it gives UnsupportedOperationException as it cannot
        // create an object
//        emptyMap.put("Tom", "Python");
//        System.out.println(emptyMap.get("Tom"));

        //maps using Guava: Came by downloading the dependency -> com.google.guava

        Map<String, String> titleMap = ImmutableMap.of("Google", "Google", "Amazon", "Amazon SHopping");
        System.out.println(titleMap.get("Amazon"));
//        titleMap.put("Rediff","Rediff");//UnsupportedOperationException


    }
}
