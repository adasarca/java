/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package concurrency;

public class SimpleThread extends Thread {

    private int seconds;
    private boolean done;

    public SimpleThread(int seconds) {
        this.seconds = seconds;
        this.done = false;
    }

    @Override
    public void run() {
        System.out.println(String.format("Executing thread [%s] for %d seconds", Thread.currentThread().getName(), this.seconds));

        try {
            Thread.sleep(this.seconds * 1000);
            this.done = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isDone() {
        return done;
    }
}
