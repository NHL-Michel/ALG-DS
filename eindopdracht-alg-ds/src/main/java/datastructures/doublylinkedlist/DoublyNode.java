package datastructures.doublylinkedlist;

import assets.dataset.Person;

public class DoublyNode {
    protected Person data;
    protected DoublyNode next;
    protected DoublyNode prev;

    public DoublyNode(Person data) {
        this.data = data;
    }

    public Person getData() {
        return this.data;
    }

    public DoublyNode getNext() {
        return this.next;
    }

    public void setNext(DoublyNode next) {
        this.next = next;
    }
}