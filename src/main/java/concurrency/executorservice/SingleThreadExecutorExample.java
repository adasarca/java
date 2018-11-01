package concurrency.executorservice;

import concurrency.SimpleRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutorExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            Runnable runnable = new SimpleRunnable(i);
            executorService.execute(runnable);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            if (!executorService.isTerminated()) {
                System.out.println("Cancelling unfinished tasks");
                executorService.shutdownNow();
            }
        }
    }
}
