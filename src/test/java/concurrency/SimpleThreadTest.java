/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package concurrency;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNull;

public class SimpleThreadTest {

    @Test
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