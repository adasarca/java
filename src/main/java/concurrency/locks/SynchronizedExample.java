/**
 * Created by Ada.Sarca
 * Date: 11/1/2018
 */
package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample implements Runnable {
    private SynchronizedResource resource;

    public SynchronizedExample(SynchronizedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        this.resource.increaseCount();
        this.resource.increaseBlockCount();
    }

    public static void main(String[] args) {
        SynchronizedResource synchronizedResource = new SynchronizedResource();

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SynchronizedExample(synchronizedResource));
            executorService.execute(SynchronizedResource::increaseStaticCount);
            executorService.execute(SynchronizedResource::increaseStaticBlockCount);
        }
        executorService.shutdown();

        System.out.println("Count: " + synchronizedResource.getCount());
        System.out.println("Block count: " + synchronizedResource.getBlockCount());
        System.out.println("Static count: " + SynchronizedResource.getStaticCount());
        System.out.println("Static block count: " + SynchronizedResource.getStaticBlockCount());
    }
}
