/**
 * Created by Ada.Sarca
 * Date: 11/1/2018
 */
package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LockExample implements Runnable {

    private LockResource lockResource;

    public LockExample(LockResource lockResource) {
        this.lockResource = lockResource;
    }

    @Override
    public void run() {
        this.lockResource.increaseCount();
        this.lockResource.increaseCountTwice();
        this.lockResource.increaseTryCount();
    }

    public static void main(String[] args) {
        LockResource lockResource = new LockResource();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new LockExample(lockResource));
        }
        executorService.shutdown();

        System.out.println("Count: " + lockResource.getCount());
        System.out.println("Count: " + lockResource.getTryCount());
    }
}
