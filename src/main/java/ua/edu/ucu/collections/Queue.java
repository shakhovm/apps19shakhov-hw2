package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList data;

    public Queue()
    {
        data = new ImmutableLinkedList();
    }

    public Object peek()
    {
        return data.getFirst();
    }

    public Object dequeue()
    {
        Object object = peek();
        data = data.removeFirst();
        return object;
    }

    public void enqueue(Object e)
    {
        data = data.addLast(e);
    }

    @Override
    public String toString()
    {
        return data.toString();
    }
}
