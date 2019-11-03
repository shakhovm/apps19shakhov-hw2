package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList data;

    public Stack()
    {
        data = new ImmutableLinkedList();
    }

    public Object peek()
    {
        return data.getFirst();
    }

    public Object pop()
    {
        Object object = peek();
        data = data.removeFirst();
        return object;
    }

    public void push(Object e)
    {
        data = data.addFirst(e);
    }

    @Override
    public String toString()
    {
        return data.toString();
    }
    
}
