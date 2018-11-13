/**
 * Created by Ada.Sarca
 * Date: 11/12/2018
 */
package concurrency;

public class ConcurrentCollectionProducer implements Runnable {

    private int mapDelay;
    private ConcurrentCollectionResource resource;

    public ConcurrentCollectionProducer(int mapDelay, ConcurrentCollectionResource resource) {
        this.mapDelay = mapDelay;
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(this.mapDelay * 1000);
                this.resource.incrementMapEntry("map-" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(1000);
                this.resource.addToConcurrentQueue(Thread.currentThread().getName() + "-c-" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                this.resource.addToBlockingQueue(Thread.currentThread().getName() + "-b-" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
