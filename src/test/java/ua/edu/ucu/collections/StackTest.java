package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    private Stack mainStack;

    @Before
    public void setUp()
    {
        mainStack = new Stack();
        mainStack.push(1);
        mainStack.push(2);
        mainStack.push(3);
    }

    @Test
    public void testEnqueue() {

        mainStack.push(4);
        String expectedString = "[4, 3, 2, 1]";
        assertEquals(expectedString, mainStack.toString());
    }


    @Test
    public void testPeek() {

        assertEquals(mainStack.peek(), 3);
    }

    @Test
    public void testDequeue() {

        assertEquals(3, mainStack.pop());

        String expectedString = "[2, 1]";
        assertEquals(expectedString, mainStack.toString());
    }
}
