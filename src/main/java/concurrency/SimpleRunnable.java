package concurrency;

public class SimpleRunnable implements Runnable {

    private int seconds;

    public SimpleRunnable(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        System.out.println("Executing thread " + Thread.currentThread().getName());

        try {
            Thread.sleep(this.seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleRunnable runnable = new SimpleRunnable(5);
        runnable.run();

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
