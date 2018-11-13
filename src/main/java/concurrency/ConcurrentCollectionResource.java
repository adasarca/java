/**
 * Created by Ada.Sarca
 * Date: 11/12/2018
 */
package concurrency;

import java.util.concurrent.*;

public class ConcurrentCollectionResource {

    private ConcurrentMap<String, Integer> concurrentMap;
    private ConcurrentLinkedQueue<String> concurrentQueue;
    private LinkedBlockingQueue<String> blockingQueue;

    public ConcurrentCollectionResource() {
        this.concurrentMap = new ConcurrentHashMap<>();
        this.concurrentQueue = new ConcurrentLinkedQueue<>();
        this.blockingQueue = new LinkedBlockingQueue<>();
    }

    public void incrementMapEntry(String key) {
        this.concurrentMap.putIfAbsent(key, 0);
        this.concurrentMap.computeIfPresent(key, (k,v) -> v + 1);
    }

    public Integer getMapEntry(String key) {
        return this.concurrentMap.get(key);
    }

    public void addToConcurrentQueue(String element) {
        this.concurrentQueue.add(element);
    }

    public String pollFromConcurrentQueue() {
        return this.concurrentQueue.poll();
    }

    public void addToBlockingQueue(String element) {
        this.blockingQueue.add(element);
    }

    public String pollFromBlockingQueue(int timeout, TimeUnit timeUnit) {
        try {
            return this.blockingQueue.poll(timeout, timeUnit);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException on poll(timeout): " + e.getMessage());
            return null;
        }
    }

    public String takeFromBlockingQueue() {
        try {
            return this.blockingQueue.take();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException on take(): " + e.getMessage());
            return null;
        }
    }
}
