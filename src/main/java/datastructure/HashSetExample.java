/**
 * Created by Ada.Sarca
 * Date: 11/15/2018
 */
package datastructure;

import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {
        HashSet<Resource> hashSet = new HashSet<>();

        //add
        for (int i = 0; i < 10; i++) {
            hashSet.add(new Resource(i, "test-" + i));
        }
        hashSet.add(new Resource(1, "test-1"));

        //remove
        hashSet.remove(new Resource(2, "test-2"));

        //iterate
        for (Resource resource : hashSet) {
            System.out.println(resource);
        }
    }
}
