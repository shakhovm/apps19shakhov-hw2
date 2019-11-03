package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    private Queue mainQueue;

    @Before
    public void setUp()
    {
        mainQueue = new Queue();
        mainQueue.enqueue(1);
        mainQueue.enqueue(2);
        mainQueue.enqueue(3);
    }

    @Test
    public void testEnqueue() {

        mainQueue.enqueue(4);
        String expectedString = "[1, 2, 3, 4]";
        assertEquals(expectedString, mainQueue.toString());
    }


    @Test
    public void testPeek() {

        assertEquals(mainQueue.peek(), 1);
    }

    @Test
    public void testDequeue() {

        assertEquals(1, mainQueue.dequeue());

        String expectedString = "[2, 3]";
        assertEquals(expectedString, mainQueue.toString());
    }
    
}
