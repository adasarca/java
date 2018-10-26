package concurrency.old;

import java.util.concurrent.*;

/**
 * Created by Ada on 11/2/2016.
 */
public class UsingFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        };
        Future<Integer> future = executorService.submit(task);

        System.out.println("future done? " + future.isDone());
        Integer result = null;
        try {
            result = future.get();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.println("result: " + result);

        executorService.shutdownNow();
    }
}
