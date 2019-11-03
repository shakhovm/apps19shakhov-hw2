package ua.edu.ucu.collections.immutable;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
final class Node {

    private Object data;

    private Node next = null;

    private Node prev = null;

}
