package concurrency.resource;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class AtomicVariableExample implements Callable<String> {

    private AtomicVariableResource resource;

    public AtomicVariableExample(AtomicVariableResource resource) {
        this.resource = resource;
    }

    @Override
    public String call() throws Exception {
        int count = resource.incrementAndGetCount();

        return String.format("Thread [%s]: count [%d]", Thread.currentThread().getName(), count);
    }

    public static void main(String[] args) {
        AtomicVariableResource resource = new AtomicVariableResource();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<AtomicVariableExample> tasks = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            AtomicVariableExample task = new AtomicVariableExample(resource);
            tasks.add(task);
        }

        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Final count: " + resource.getCount());
    }
}
