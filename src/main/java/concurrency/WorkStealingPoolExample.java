package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 1; i <= 10; i++) {
            Runnable runnable = new SimpleRunnable(i);
            executorService.execute(runnable);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
