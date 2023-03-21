package datastructures.doublylinkedlist;

import assets.dataset.Person;

public class DoublyNode {
    private Person data;
    private DoublyNode next;
    private DoublyNode prev;

    public DoublyNode(Person data) {
        this.data = data;
    }

    public Person getData() {
        return this.data;
    }

    public void setData(Person data) {
        this.data = data;
    }
    public DoublyNode getNext() {
        return this.next;
    }

    public DoublyNode getPrev() {
        return this.prev;
    }
    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }
    public void setNext(DoublyNode next) {
        this.next = next;
    }
}