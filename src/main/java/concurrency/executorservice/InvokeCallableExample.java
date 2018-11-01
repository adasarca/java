/**
 * Created by Ada.Sarca
 * Date: 10/29/2018
 */
package concurrency.executorservice;

import concurrency.SimpleCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeCallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //invoke all
        System.out.println("Invoke all tasks: ");
        List<SimpleCallable> tasks = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tasks.add(new SimpleCallable(i));
        }
        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);
            for (Future<String> future : futures) {
                String result = future.get();
                System.out.println(result);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //invoke any
        System.out.println("\nInvoke any task: ");
        tasks = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            tasks.add(new SimpleCallable(i));
        }
        try {
            String result = executorService.invokeAny(tasks);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
