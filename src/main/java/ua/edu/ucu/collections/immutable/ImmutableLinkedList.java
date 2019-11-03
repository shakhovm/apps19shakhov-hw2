package ua.edu.ucu.collections.immutable;

import java.util.Arrays;


public class ImmutableLinkedList implements ImmutableList {

    private Node head;

    private Node tail;

    private int size = 0;

    public ImmutableLinkedList(Object[] data) {
        int size = data.length;
        Node[] nodes = createArrayNodes(data, size);
        head = nodes[0];
        tail = nodes[1];
        this.size = size;
    }

    public ImmutableLinkedList(Node head, Node tail, int size)
    {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }


    public ImmutableLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }


    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }

    private ImmutableList addObjectToEmpty(Object e)
    {
        Node newTail = new Node(null, null, null);
        Node newHead = new Node(e, newTail, null);
        newHead.getNext().setPrev(newHead);
        return new ImmutableLinkedList(newHead, newHead.getNext(), 1);
    }

    private static Node[] createArrayNodes(Object[] c, int newSize)
    {
        Node newHead = new Node(c[0], null, null);
        Node newTail = new Node(null, null, newHead);
        newHead.setNext(newTail);
        for (int i = 1; i < newSize; i++) {
            Node newNode = new Node(c[i], newTail, newTail.getPrev());
            newTail.setPrev(newNode);
            newTail.getPrev().getPrev().setNext(newNode);
        }
        return new Node[]{newHead, newTail};
    }

    @Override
    public ImmutableList add(int index, Object e) {

        LinkedListHelper.indexErrorChecker(index, size);

        if (isEmpty())
        {
            return addObjectToEmpty(e);
        }
        Node[] nodes = LinkedListHelper.copyNodes(index, size, head);

        Node currentNode = nodes[2];

        Node newNode = new Node(e, currentNode, currentNode.getPrev());
        currentNode.setPrev(newNode);

        if (currentNode.getPrev().getPrev() != null)
        {
            currentNode.getPrev().getPrev().setNext(newNode);
        }

        else
        {
            nodes[0] = currentNode.getPrev();
        }

        return new ImmutableLinkedList(nodes[0], nodes[1], size + 1);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {

        LinkedListHelper.indexErrorChecker(index, size);

        int newSize = c.length;
        Node[] arrayNodes = createArrayNodes(c, newSize);
        if (isEmpty())
        {
            return new ImmutableLinkedList(arrayNodes[0], arrayNodes[1], newSize);
        }

        Node[] nodes = LinkedListHelper.copyNodes(index, size, head);
        Node currentNode = nodes[2];

        if(currentNode.getPrev() != null)
        {
            currentNode.getPrev().setNext(arrayNodes[0]);
            currentNode.getPrev().getNext().setPrev(currentNode.getPrev());
        }

        else
        {
            nodes[0] = arrayNodes[0];
        }

        currentNode.setPrev(arrayNodes[1].getPrev());
        currentNode.getPrev().setNext(currentNode);

        return new ImmutableLinkedList(nodes[0], nodes[1], size + newSize);
    }

    @Override
    public Object get(int index) {

        LinkedListHelper.indexErrorChecker(index, size - 1);

        return LinkedListHelper.findNode(index, head).getData();
    }

    @Override
    public ImmutableList remove(int index) {
        LinkedListHelper.indexErrorChecker(index, size - 1);
        Node[] nodes = LinkedListHelper.copyNodes(index, size, head);
        if (nodes[2].getPrev() != null)
        {
            nodes[2].getPrev().setNext(nodes[2].getNext());
            nodes[2].getPrev().getNext().setPrev(nodes[2].getPrev());
        }
        else {
            nodes[0] = nodes[2].getNext();
        }

        return new ImmutableLinkedList(nodes[0], nodes[1], size - 1);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        LinkedListHelper.indexErrorChecker(index, size - 1);
        Node[] nodes = LinkedListHelper.copyNodes(index, size, head);
        nodes[2].setData(e);
        return new ImmutableLinkedList(nodes[0], nodes[1], size);
    }

    @Override
    public int indexOf(Object e) {
        Node newHead = head;
        for (int i = 0; i < size; i++) {
            if (newHead.getData() == e)
            {
                return i;
            }
            newHead = newHead.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public ImmutableLinkedList addFirst(Object e)
    {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e)
    {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst()
    {
        return head.getData();
    }

    public Object getLast()
    {
        return tail.getPrev().getData();
    }

    public ImmutableLinkedList removeFirst()
    {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast()
    {
        return (ImmutableLinkedList) remove(size - 1);
    }

    @Override
    public Object[] toArray() {
        Node newHead = head;
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = newHead.getData();
            newHead = newHead.getNext();
        }
        return array;
    }


    @Override
    public String toString()
    {
        return Arrays.toString(toArray());
    }
}
