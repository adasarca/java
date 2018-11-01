package concurrency.executorservice;

import concurrency.SimpleCallable;
import concurrency.SimpleRunnable;

import java.util.concurrent.*;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        //schedule at fixed rate
        Runnable task1 = new SimpleRunnable(5);
        executorService.scheduleAtFixedRate(task1, 0, 5, TimeUnit.SECONDS);

        //schedule with fixed delay
        Runnable task2 = new SimpleRunnable(4);
        executorService.scheduleWithFixedDelay(task2, 0, 4, TimeUnit.SECONDS);

        //schedule callable
        Callable<String> task3 = new SimpleCallable(3);
        ScheduledFuture<String> future = executorService.schedule(task3, 10, TimeUnit.SECONDS);
        System.out.println("Callable will start in " + future.getDelay(TimeUnit.SECONDS) + " seconds...");
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //wait 10 more seconds before shutting down executor service
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
