package concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        Runnable task1 = new SimpleRunnable(5);
        executorService.scheduleAtFixedRate(task1, 0, 5, TimeUnit.SECONDS);

        Runnable task2 = new SimpleRunnable(4);
        executorService.scheduleWithFixedDelay(task2, 0, 4, TimeUnit.SECONDS);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
