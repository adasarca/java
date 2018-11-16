/**
 * Created by Ada.Sarca
 * Date: 11/16/2018
 */
package datastructures;

import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        TreeSet<Resource> treeSet = new TreeSet<>();

        //add
        for (int i = 10; i > 0; i--) {
            treeSet.add(new Resource(i, "test-" + i));
        }
        treeSet.add(new Resource(1, "test-1"));

        //remove
        treeSet.remove(new Resource(2, "test-2"));

        //iterate
        for (Resource resource : treeSet) {
            System.out.println(resource);
        }
    }
}
