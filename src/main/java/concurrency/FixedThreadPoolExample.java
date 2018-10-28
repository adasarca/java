package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new SimpleRunnable(i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
