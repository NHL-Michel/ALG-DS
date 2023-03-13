package datastructures.doublylinkedlist;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;

import java.util.ArrayList;

public class DoublyLinkedL implements DataStructure {
    private ArrayList<Person> dataset;
    private DoublyNode head;
    private DoublyNode tail;


    public DoublyLinkedL() {
        this.dataset = Data.generateRandomPersons(5, 100);
        this.head = null;
        this.tail = null;
    }

    public DoublyNode getNode(int index) {
        DoublyNode currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    public void add(Person value) {
        //Check if index is out of bounds
        // create new node
        DoublyNode newNode = new DoublyNode(value);

        //if list is empty, head and tail points to newNode
        if (this.head == null) {
            this.head = this.tail = newNode;
            //head's previous will be null
            this.head.prev = null;
            //tail's next will be null
            this.tail.next = null;
        } else {
            //add newNode to the end of list. tail->next set to newNode
            this.tail.next = newNode;
            //newNode->previous set to tail
            newNode.prev = tail;
            //newNode becomes new tail
            this.tail = newNode;
            //tail's next point to null
            this.tail.next = null;
        }
    }

    public int getSize() {
        int size = 0;
        DoublyNode n = this.head;

        while (n != null) {
            size += 1;
            n = n.getNext();
        }

        return size;
    }

    public ArrayList<Person> getDataset() {
        return this.dataset;
    }

    public String getNodeLayout() {
        DoublyNode n = this.head;
        StringBuilder nodeString = new StringBuilder();

        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return null;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (n != null) {
            if (n.prev == null) {
                System.out.println("prev is: null");
            } else {
                System.out.println("prev is: " + n.prev.data.getName());
            }
            System.out.println("cur is:" + n.data.getName());
            System.out.println("next is: " + n.next.data.getName());
            System.out.println("/////////////////////////");
            //Print each node and then go to next.
            nodeString.append("{Name: " + n.getData().getName() + ", age : " + n.getData().getAge() + "} > ");
            n = n.getNext();
        }
        nodeString.append("NULL");
        System.out.println(nodeString.toString());
        return nodeString.toString();
    }

    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p);
        }
    }

    @Override
    public boolean search(Object searchterm) {
        return false;
    }

    @Override
    public void sort(String type) {

    }
}

