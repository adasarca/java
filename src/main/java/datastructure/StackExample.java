/**
 * Created by Ada.Sarca
 * Date: 11/16/2018
 */
package datastructure;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<Resource> stack = new Stack<>();

        //push
        for (int i = 0; i < 10; i++) {
            stack.push(new Resource(i, "test-" + i));
        }

        //pop
        while(!stack.isEmpty()) {
            Resource resource = stack.pop();
            System.out.println(resource);
        }
    }
}
