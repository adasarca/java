package concurrency.sync;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SharedResourceTest {

    @Test
    public void Test() throws InterruptedException {
        //setup
        SharedResource<Integer> resource = new SharedResource<>();
        ResourceRunnable p1 = new ResourceRunnable(resource, 10);
        ResourceRunnable p2 = new ResourceRunnable(resource, 1000);
        ResourceRunnable p3 = new ResourceRunnable(resource, 100000);

        //test
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(p3);

        //verify
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

    }

}