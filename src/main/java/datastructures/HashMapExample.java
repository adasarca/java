/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package datastructures;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        HashMap<Integer, Resource> hashMap = new HashMap<>();

        //put
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, new Resource(i, "test-" + i));
        }
        hashMap.put(10, null);
        hashMap.put(0, new Resource(0, "test-override"));
        hashMap.putIfAbsent(1, new Resource(1, "test-absent"));

        //get
        if (hashMap.containsKey(3)) {
            System.out.println("Hash map contains key 3");
        } else {
            System.out.println("Hash map doesn't contain key 3");
        }
        System.out.println("Get missing key: " + hashMap.get(13));
        System.out.println();

        //iterate
        System.out.println("Printing hash map by entry set:");
        for (Map.Entry<Integer, Resource> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        System.out.println("Printing hash map by key set");
        for (Integer key : hashMap.keySet()) {
            System.out.println(key + ": " + hashMap.get(key));
        }
    }
}
