package Main;


import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {0, 1, 2, 3, 4, 5, 6};
        ImmutableLinkedList linkedList = new ImmutableLinkedList(array);
        ImmutableLinkedList linkedList1 = (ImmutableLinkedList) linkedList.addAll(0, array);
//        for (Integer i: array) {
//            linkedList = (ImmutableLinkedList) linkedList.add(i);
//        }
        System.out.println(linkedList.toString());
        System.out.println(linkedList1.toString());
    }
}
