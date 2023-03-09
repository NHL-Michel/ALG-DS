package datastructures.doublylinkedlist;

import assets.dataset.Person;
import datastructures.linkedlist.Node;

public class DoublyNode extends Node {

    private DoublyNode prev;

    public DoublyNode(Person data) {
        super(data);
    }

    public DoublyNode getPrev() {
        return this.prev;
    }

    public void setPrev(DoublyNode prev) {
        this.prev = prev;
    }
}
