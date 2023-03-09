package datastructures.linkedlist;

import assets.dataset.Person;

public class Node {
    private Person data;
    private Node next;

    public Node(Person data) {
        this.data = data;
    }

    public Person getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
