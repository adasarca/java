/**
 * Created by Ada.Sarca
 * Date: 11/12/2018
 */
package concurrency;

public class ConcurrentCollectionProducer implements Runnable {

    private int seconds;
    private ConcurrentCollectionResource resource;

    public ConcurrentCollectionProducer(int seconds, ConcurrentCollectionResource resource) {
        this.seconds = seconds;
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(this.seconds * 1000);
                this.resource.incrementMapEntry("map-" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(this.seconds * 1000);
                this.resource.addToConcurrentQueue("concurrent-queue-" + i + "-" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(this.seconds * 1000);
            this.resource.addToBlockingQueue("block-queue-1-" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
