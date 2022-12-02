import java.util.*;

public class CollectionsClass {
    public static void main(String[] args) {
       // HashTable();
       // HashMap();
        LinkedHashMap();

    }

    public static void HashTable() {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("one", 1);
        hashtable.put("two", 2);
        hashtable.put("three", 3);


        for (Map.Entry<String, Integer> stringIntegerEntry : hashtable.entrySet()) {
            System.out.println(stringIntegerEntry);
        }
    }

    public static void HashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        hashMap.put("2", 2);
        hashMap.put("3", 3);


        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            System.out.println(stringIntegerEntry);

        }

    }

    public static void LinkedHashMap() {
        LinkedHashMap<Integer, Integer> linkedHashMap =
                new LinkedHashMap<>(16, 0.75f, false);

        linkedHashMap.put(1, 1);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(4,4);

        /*for (Map.Entry<Integer, Integer> integerIntegerEntry : linkedHashMap.entrySet()) {
            System.out.println(integerIntegerEntry.getKey() + " "
                    + integerIntegerEntry.getValue());

        }*/

        System.out.println(linkedHashMap);


        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "test1");
        treeMap.put(2, "test2");
        treeMap.put(1, "test3");
        treeMap.put(4, "test4");
        treeMap.put(6, "test5");
        treeMap.put(7, "test6");
        treeMap.put(5, "test8");

        //System.out.println(treeMap.headMap(4));

        //System.out.println(treeMap.descendingMap());
        System.out.println(treeMap.lastEntry());


        TreeMap<String, Integer> treeMap1 = new TreeMap<>();
        treeMap1.put("111", 1);
        treeMap1.put("22344", 4);
        System.out.println(treeMap1);

    }

}
