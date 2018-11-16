/**
 * Created by Ada.Sarca
 * Date: 11/16/2018
 */
package datastructures;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        //using comparable
        System.out.println("Using Comparable...");
        PriorityQueue<Resource> naturalPriorityQueue = new PriorityQueue<>();
        for (int i = 10; i > 0; i--) {
            naturalPriorityQueue.add(new Resource(i, "test-" + i));
        }

        while(!naturalPriorityQueue.isEmpty()) {
            Resource resource = naturalPriorityQueue.poll();
            System.out.println(resource);
        }

        //using comparator
        System.out.println("Using Comparator...");
        ComparatorExample comparatorExample = new ComparatorExample();
        List<Resource> resources = comparatorExample.buildResourceList();

        PriorityQueue<Resource> namePriorityQueue = new PriorityQueue<>(Comparator.comparing(Resource::getPrice));
        namePriorityQueue.addAll(resources);

        while(!namePriorityQueue.isEmpty()) {
            Resource resource = namePriorityQueue.poll();
            System.out.println(resource);
        }
    }
}
