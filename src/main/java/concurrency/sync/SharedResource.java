package concurrency.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedResource<T> {

    private T value;

    private boolean readLock;
    private boolean writeLock;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public synchronized void setValue(T value) throws InterruptedException {
        while (this.readLock) {
            wait();
        }

        this.writeLock = true;
        this.value = value;
        System.out.println(String.format("[%s][%s] Write value [%s]",
                Thread.currentThread().getName(), this.dateFormat.format(new Date()), value));
        this.writeLock = false;
        this.notifyAll();
    }

    public T getValue() throws InterruptedException {
        synchronized (this) {
            while (this.writeLock) {
                wait();
            }
        }

        this.readLock = true;
        T value = this.value;
        System.out.println(String.format("[%s][%s] Read value [%s]",
                Thread.currentThread().getName(), this.dateFormat.format(new Date()), value));
        this.readLock = false;

        synchronized (this) {
            notifyAll();
        }
        return value;
    }
}
