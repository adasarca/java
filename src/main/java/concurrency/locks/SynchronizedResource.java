/**
 * Created by Ada.Sarca
 * Date: 11/1/2018
 */
package concurrency.locks;

public class SynchronizedResource {

    private static int staticCount = 0;
    private static int staticBlockCount = 0;

    private int count;
    private int blockCount;

    public SynchronizedResource() {
        this.count = 0;
        this.blockCount = 0;
    }

    public synchronized static void increaseStaticCount() {
        staticCount += 3;
    }

    public static void increaseStaticBlockCount() {
        synchronized (SynchronizedResource.class) {
            staticBlockCount += 4;
        }
    }

    public synchronized void increaseCount() {
        this.count++;
    }

    public void increaseBlockCount() {
        synchronized (this) {
            this.blockCount += 2;
        }
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public static int getStaticBlockCount() {
        return staticBlockCount;
    }

    public int getCount() {
        return this.count;
    }

    public int getBlockCount() {
        return blockCount;
    }
}
