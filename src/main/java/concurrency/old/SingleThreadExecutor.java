package concurrency.old;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ada on 11/2/2016.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit( () -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Hello " + threadName);
                }
        );

        executorService.submit( () -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Hello " + threadName + ". This is the second task.");
                }
        );

        try {
            System.out.println("Attempt to shutdown executor...");
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            System.err.println("Tasks were interrupted");
        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("Cancelling non-finished tasks...");
            }
            executorService.shutdownNow();
            System.out.println("Shutdown finished");
        }
    }
}
