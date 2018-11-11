/**
 * Created by Ada.Sarca
 * Date: 11/1/2018
 */
package concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockResource {

    private ReentrantLock countLock;
    private ReentrantLock tryCountLock;
    private ReentrantReadWriteLock readWriteLock;

    private int count;
    private int tryCount;
    private int readWriteCount;

    public LockResource() {
        this.countLock = new ReentrantLock();
        this.tryCountLock = new ReentrantLock();
        this.readWriteLock = new ReentrantReadWriteLock();

        this.count = 0;
        this.tryCount = 0;
        this.readWriteCount = 0;
    }

    public void increaseCount() {
        this.countLock.lock();
        try {
            //critical section here
            this.count++;
        } finally {
            this.countLock.unlock();
        }
    }

    public void increaseCountTwice() {
        this.countLock.lock();
        this.count += 2;
        this.countLock.unlock();
    }

    public void increaseTryCount() {
        boolean lockAquired = false;
        try {
            lockAquired = this.tryCountLock.tryLock(1, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (lockAquired) {
            try {
                //critical section here
                this.tryCount++;
            } finally {
                this.tryCountLock.unlock();
            }
        }
    }

    public void increaseReadWriteCount() {
        this.readWriteLock.writeLock().lock();
        this.readWriteCount++;
        this.readWriteLock.writeLock().unlock();
    }

    public int getCount() {
        return count;
    }

    public int getTryCount() {
        return tryCount;
    }

    public int getReadWriteCount() {
        int value;

        this.readWriteLock.readLock().lock();
        value = this.readWriteCount;
        this.readWriteLock.readLock().unlock();

        return value;
    }
}
