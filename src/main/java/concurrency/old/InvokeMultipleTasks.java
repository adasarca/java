package concurrency.old;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ada on 11/2/2016.
 */
public class InvokeMultipleTasks {
    public static void main(String[] args) {
        List<Callable<String>> tasks = Arrays.asList(
                () -> Thread.currentThread().getName() + " task-1",
                () -> Thread.currentThread().getName() + " task-2",
                () -> Thread.currentThread().getName() + " task-3"
        );

        ExecutorService executorService = Executors.newWorkStealingPool();
        try {
            executorService.invokeAll(tasks)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception exception) {
                            throw new IllegalStateException();
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
