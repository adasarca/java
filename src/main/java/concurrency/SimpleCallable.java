/**
 * Created by Ada.Sarca
 * Date: 10/29/2018
 */
package concurrency;

import java.util.concurrent.*;

public class SimpleCallable implements Callable<String> {

    private int seconds;

    public SimpleCallable(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String call() throws Exception {
        System.out.println(String.format("Executing thread [%s] for %d seconds", Thread.currentThread().getName(), this.seconds));

        try {
            Thread.sleep(this.seconds * 1000);
            return "Successful sleep of " + this.seconds + " seconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(new SimpleCallable(5));
        try {
            String result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //with timeout
        future = executorService.submit(new SimpleCallable(10));
        try {
            String result = future.get(5, TimeUnit.SECONDS);
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
