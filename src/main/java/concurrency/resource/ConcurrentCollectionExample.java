/**
 * Created by Ada.Sarca
 * Date: 11/12/2018
 */
package concurrency.resource;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentCollectionExample implements Callable<String> {

    private int mapDelay;
    private ConcurrentCollectionResource resource;

    public ConcurrentCollectionExample(int seconds, ConcurrentCollectionResource resource) {
        this.mapDelay = seconds;
        this.resource = resource;
    }

    @Override
    public String call() throws Exception {
        StringBuilder stringBuilder = new StringBuilder(
                String.format("Thread [%s] with mapDelay [%d]: ", Thread.currentThread().getName(), this.mapDelay)
        );

        stringBuilder.append("\n    ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(this.mapDelay * 1000);
                Integer value = this.resource.getMapEntry("map-" + i);
                stringBuilder.append(String.format("map-%d [%d] ", i, value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stringBuilder.append("\n    ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                String cQueue = this.resource.pollFromConcurrentQueue();
                stringBuilder.append(String.format("cQueue-%d [%s] ", i, cQueue));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stringBuilder.append("\n    ");
        try {
            Thread.sleep(1000);
            String bQueue1 = this.resource.takeFromBlockingQueue();
            stringBuilder.append(String.format("bQueue-1 [%s] ", bQueue1));

            for (int i = 1; i < 3; i++) {
                Thread.sleep(1000);
                String bQueue = this.resource.pollFromBlockingQueue(1, TimeUnit.SECONDS);
                stringBuilder.append(String.format("bQueue-%d [%s] ", i, bQueue));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ConcurrentCollectionResource resource = new ConcurrentCollectionResource();

        ExecutorService producerService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            ConcurrentCollectionProducer producer = new ConcurrentCollectionProducer(i % 4, resource);
            producerService.execute(producer);
        }

        ExecutorService consumerService = Executors.newFixedThreadPool(20);
        List<ConcurrentCollectionExample> consumers = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            consumers.add(new ConcurrentCollectionExample(i % 5, resource));
        }
        try {
            List<Future<String>> futures = consumerService.invokeAll(consumers);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Exception on invokeAll(): " + e.getMessage());
        }

        consumerService.shutdown();
        producerService.shutdown();
    }
}
