package concurrency.sync;

public class ResourceRunnable implements Runnable {

    private SharedResource<Integer> resource;

    private Integer step;

    public ResourceRunnable(SharedResource<Integer> resource, Integer step) {
        this.resource = resource;
        this.step = step;
    }

    @Override
    public void run() {
        for (int i = this.step; i < 10 * this.step; i += this.step) {
            try {
                Integer value = resource.getValue();
                resource.setValue(i);
                Thread.sleep(5);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
