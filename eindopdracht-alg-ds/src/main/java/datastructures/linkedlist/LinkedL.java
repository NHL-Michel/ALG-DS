package datastructures.linkedlist;

import assets.dataset.data;
import assets.interfaces.DataStructure;

import java.util.*;

public class LinkedL implements DataStructure {
    private ArrayList<Integer> dataset;
    private Node head;
    private Node tail;

    public LinkedL() {
        this.dataset = data.generateRandomDataset(50000, 500);
    }

    @Override
    public void build(){
        for (Integer i : dataset) {
            this.appendNode(i);
        }
    }

    @Override
    public void search() {

    }

    @Override
    public void sort() {

    }

    public ArrayList<Integer> getDataset() {
        return this.dataset;
    }

    /**
     * append a new node to the end of the linked list
     *
     * @param data to be set in the linked list
     */
    public void appendNode(int data) {
        Node n = new Node(data);

        // check if it already contains nodes
        if (this.getSize() > 0) {
            // if it does contain atleast the head node, continue
            Node tmp = this.head;
            // while a node is not equal to null, continue to next node
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            // if the last node.next is equal to null, set the last node
            tmp.setNext(n);
            this.tail = n;
        } else {
            this.head = n;
        }
    }

    /**
     * get the size of the linked list
     *
     * @return
     */
    public int getSize() {
        int size = 0;
        Node n = this.head;

        while (n != null) {
            size += 1;
            n = n.getNext();
        }

        return size;
    }
}
