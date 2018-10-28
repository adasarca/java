package concurrency;

public class SimpleRunnable implements Runnable {

    private int seconds;

    public SimpleRunnable(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        System.out.println(String.format("Executing thread [%s] for %d seconds", Thread.currentThread().getName(), this.seconds));

        try {
            Thread.sleep(this.seconds * 1000);
        } catch (InterruptedException e) {
            System.err.print("SimpleRunnable interrupted: ");
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
