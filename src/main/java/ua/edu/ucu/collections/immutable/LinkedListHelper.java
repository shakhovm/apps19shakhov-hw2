package ua.edu.ucu.collections.immutable;

final class LinkedListHelper {

    public LinkedListHelper() {
    }

    public static void indexErrorChecker(int index, int size)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public static Node findNode(int index, Node node)
    {
        Node newNode = node;
        for (int i = 0; i < index; i++) {
            newNode = newNode.getNext();
        }
        return newNode;
    }

    public static Node[] copyNodes(int index, int size, Node currentNode)
    {

        Node newNode = currentNode;
        Node head = new Node();
        Node newHead = head;
        Node indexNode = null;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                indexNode = newHead;
            }
            newHead.setData(newNode.getData());
            newHead.setNext(new Node(null, null, newHead));
            if (i == size - 1)
            {
                break;
            }
            newHead = newHead.getNext();
            newNode = newNode.getNext();
        }

        Node tail = new Node(null, null, newHead);

        if (index == size)
        {
            indexNode = tail;
        }

        return new Node[]{head, tail, indexNode};
    }
}
