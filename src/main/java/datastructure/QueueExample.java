/**
 * Created by Ada.Sarca
 * Date: 11/16/2018
 */
package datastructure;

import java.util.LinkedList;

public class QueueExample {

    public static void main(String[] args) {
        LinkedList<Resource> queue = new LinkedList<>();

        //add
        for (int i = 0; i < 10; i++) {
            queue.add(new Resource(i, "test-" + i));
        }

        //pop
        while(!queue.isEmpty()) {
            Resource resource = queue.pop();
            System.out.println(resource);
        }
    }
}
