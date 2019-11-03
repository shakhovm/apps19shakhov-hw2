package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private Object[] data;

    private int size = 0;


    public ImmutableArrayList()
    {
        data = new Object[size];
    }

    public ImmutableArrayList(Object[] data, int length)
    {
        this.data = Arrays.copyOf(data, length);
        size = length;
    }

    private static Object[] twoArrayPartsCopy(int newSize,
                                              Object[] from,
                                              int secondIndex,
                                              int lastBegIndex,
                                              int firstSize,
                                              int secondSize)
    {
        int firstBegIndex = 0;
        int firstIndex = 0;
        Object[] newArray = new Object[newSize];
        System.arraycopy(from, firstBegIndex, newArray, firstIndex, firstSize);

        System.arraycopy(from, lastBegIndex, newArray, secondIndex, secondSize);
        return newArray;
    }

    private static void indexErrorChecker(int index, int size)
    {
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {

        indexErrorChecker(index, size + 1);

        Object[] newData = twoArrayPartsCopy(size + 1, data,
                index + 1, index, index, size - index);
        newData[index] = e;
        return new ImmutableArrayList(newData, size + 1);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        indexErrorChecker(index, size + 1);

        int cLength = c.length;

        Object[] newData = twoArrayPartsCopy(size + cLength, data,
                index + cLength, index, index, size - index);

        System.arraycopy(c, 0, newData, index, cLength);
        return new ImmutableArrayList(newData, size + cLength);
    }

    @Override
    public Object get(int index) {

        indexErrorChecker(index, size);

        return data[index];
    }

    @Override
    public ImmutableList remove(int index) {

        indexErrorChecker(index, size);

        Object[] newData = twoArrayPartsCopy(size - 1, data,
                index, index + 1, index, size - index - 1);
        return new ImmutableArrayList(newData, size - 1);
    }

    @Override
    public ImmutableList set(int index, Object e) {

        indexErrorChecker(index, size);

        Object[] newObject = Arrays.copyOf(data, data.length);
        newObject[index] = e;
        return new ImmutableArrayList(newObject, size);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public String toString()
    {
        return Arrays.toString(data);
    }
}
