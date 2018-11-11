package concurrency.locks;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableResource {

    private AtomicInteger count;

    public AtomicVariableResource() {
        this.count = new AtomicInteger(0);
    }

    public int incrementAndGetCount() {
        return this.count.incrementAndGet();
    }

    public int getCount() {
        return this.count.get();
    }
}
