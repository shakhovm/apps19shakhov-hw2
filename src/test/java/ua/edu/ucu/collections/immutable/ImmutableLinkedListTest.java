package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    private ImmutableLinkedList mainLinkedList;

    private ImmutableLinkedList linkedList;


    private Object[] array;

    @Before
    public void setUp() {
        array = new Object[]{0, 1, 2};
        mainLinkedList = new ImmutableLinkedList(array);
    }

    @Test
    public void testToArrayToString() {
        Object[] newArray = mainLinkedList.toArray();
        assertArrayEquals(newArray, array);

        String expected = "[0, 1, 2]";

        assertEquals(expected, mainLinkedList.toString());
    }

    @Test
    public void testAdd() {
        linkedList = (ImmutableLinkedList) mainLinkedList.add(3);
        assertArrayEquals(array, mainLinkedList.toArray());

        assertEquals(linkedList.size(), 4);

        linkedList = (ImmutableLinkedList) mainLinkedList.addAll(array);

        Object[] newArray = {0, 1, 2, 0, 1, 2};

        assertArrayEquals(newArray, linkedList.toArray());

        assertArrayEquals(mainLinkedList.toArray(), array);

        linkedList = (ImmutableLinkedList) mainLinkedList.add(2, 120);

        assertEquals(linkedList.get(2), 120);

        assertEquals(mainLinkedList.get(2), 2);

        linkedList = (ImmutableLinkedList) mainLinkedList.addAll(1, array);

        newArray = new Object[]{0, 0, 1, 2, 1, 2};

        assertArrayEquals(newArray, linkedList.toArray());

        linkedList = mainLinkedList.addFirst(1);

        newArray = new Object[]{1, 0, 1, 2};
        assertArrayEquals(newArray, linkedList.toArray());

        linkedList = mainLinkedList.addLast(1);

        newArray = new Object[]{0, 1, 2, 1};
        assertArrayEquals(newArray, linkedList.toArray());

    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddWithError(){
        linkedList = (ImmutableLinkedList) mainLinkedList.add(4, 5);
    }

    @Test
    public void testRemove() {
        linkedList = (ImmutableLinkedList) mainLinkedList.remove(1);

        assertEquals(linkedList.size(), 2);

        Object[] newArray = {0, 2};

        assertArrayEquals(newArray, linkedList.toArray());


        linkedList = mainLinkedList.removeFirst();

        newArray = new Object[]{1, 2};
        assertArrayEquals(newArray, linkedList.toArray());

        linkedList = mainLinkedList.removeLast();

        newArray = new Object[]{0, 1};
        assertArrayEquals(newArray, linkedList.toArray());


    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithException() {
        linkedList = (ImmutableLinkedList) mainLinkedList.remove(3);
    }

    @Test
    public void testGetSetIndex() {
        linkedList = (ImmutableLinkedList) mainLinkedList.set(1, 150);
        assertEquals(linkedList.get(1), 150);

        assertEquals(linkedList.indexOf(151), -1);

        assertEquals(linkedList.getFirst(), 0);

        assertEquals(linkedList.getLast(), 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSetIndexWithException() {
        linkedList = (ImmutableLinkedList) mainLinkedList.set(3, 150);
    }

    @Test
    public void testEmptyClear() {
        linkedList = (ImmutableLinkedList) mainLinkedList.clear();
        assertEquals(linkedList.size(), 0);
        assertTrue(linkedList.isEmpty());
        assertEquals(mainLinkedList.size(), 3);
    }
    
}
