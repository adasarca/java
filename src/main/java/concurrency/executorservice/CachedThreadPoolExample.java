package concurrency.executorservice;

import concurrency.SimpleRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new SimpleRunnable(i);
            executorService.execute(runnable);
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 5; i++) {
            Runnable runnable = new SimpleRunnable(i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
