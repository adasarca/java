/**
 * Created by Ada.Sarca
 * Date: 11/1/2018
 */
package concurrency.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockResource {

    private ReentrantLock countLock;
    private ReentrantLock tryCountLock;

    private int count;
    private int tryCount;

    public LockResource() {
        this.countLock = new ReentrantLock();
        this.tryCountLock = new ReentrantLock();

        this.count = 0;
        this.tryCount = 0;
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

    public int getCount() {
        return count;
    }

    public int getTryCount() {
        return tryCount;
    }
}
