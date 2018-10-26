/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package concurrency;

import static org.junit.Assert.*;

public class SimpleThreadTest {

    @org.junit.Test
    public void testRun() throws Exception {
        SimpleThread simpleThread = new SimpleThread(5);
        simpleThread.start();

        InterruptedException interruptedException = null;
        try {
            simpleThread.join();
        } catch (InterruptedException exception) {
            interruptedException = exception;
        }

        assertNull(interruptedException);
        assertTrue(simpleThread.isDone());
    }
}