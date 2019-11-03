package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList mainArrayList;

    private ImmutableArrayList arrayList;


    private Object[] array;

    @Before
    public void setUp() {
        array = new Object[]{0, 1, 2};
        mainArrayList = new ImmutableArrayList(array, array.length);
    }

    @Test
    public void testToArrayToString() {
        Object[] newArray = mainArrayList.toArray();
        assertArrayEquals(newArray, array);

        String expected = "[0, 1, 2]";

        assertEquals(expected, mainArrayList.toString());
    }

    @Test
    public void testAdd() {
        arrayList = (ImmutableArrayList) mainArrayList.add(3);
        assertArrayEquals(array, mainArrayList.toArray());

        assertEquals(arrayList.size(), 4);

        arrayList = (ImmutableArrayList) mainArrayList.addAll(array);

        Object[] newArray = {0, 1, 2, 0, 1, 2};

        assertArrayEquals(newArray, arrayList.toArray());

        assertArrayEquals(mainArrayList.toArray(), array);

        arrayList = (ImmutableArrayList) mainArrayList.add(2, 120);

        assertEquals(arrayList.get(2), 120);

        assertEquals(mainArrayList.get(2), 2);

        arrayList = (ImmutableArrayList) mainArrayList.addAll(1, array);

        newArray = new Object[]{0, 0, 1, 2, 1, 2};

        assertArrayEquals(newArray, arrayList.toArray());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testAddWithError(){
        arrayList = (ImmutableArrayList) mainArrayList.add(4, 5);
    }

    @Test
    public void testRemove() {
        arrayList = (ImmutableArrayList) mainArrayList.remove(1);

        assertEquals(arrayList.size(), 2);

        Object[] newArray = {0, 2};

        assertArrayEquals(newArray, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithException() {
        arrayList = (ImmutableArrayList) mainArrayList.remove(3);
    }

    @Test
    public void testGetSetIndex() {
        arrayList = (ImmutableArrayList) mainArrayList.set(1, 150);
        assertEquals(arrayList.get(1), 150);

        assertEquals(arrayList.indexOf(151), -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetSetIndexWithException() {
        arrayList = (ImmutableArrayList) mainArrayList.set(3, 150);
    }

    @Test
    public void testEmptyClear() {
        arrayList = (ImmutableArrayList) mainArrayList.clear();
        assertEquals(arrayList.size(), 0);
        assertTrue(arrayList.isEmpty());
        assertEquals(mainArrayList.size(), 3);
    }
    
}
