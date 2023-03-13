package datastructures.doublylinkedlist;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import datastructures.linkedlist.Node;

import java.util.ArrayList;

public class DoublyLinkedL <S> implements DataStructure <S> {
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
            if (n.next == null) {
                System.out.println("next is: null");
            } else {
                System.out.println("next is: " + n.next.data.getName());
            }
            System.out.println("/////////////////////////");
            //Print each node and then go to next.
            nodeString.append("{Name: " + n.getData().getName() + ", age : " + n.getData().getAge() + "} > ");
            n = n.getNext();
        }
        nodeString.append("NULL");
        System.out.println(nodeString);
        return nodeString.toString();
    }

    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p);
        }
    }

    @Override
    public boolean search(S searchTerm) {
        DoublyNode n = this.head;

        while (n != null) {
            Integer age = n.getData().getAge();
            String name = n.getData().getName();
            if (age.equals(searchTerm) || name.equals(searchTerm)) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    public void sort(String type) {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            DoublyNode curr = this.head;
            DoublyNode next = curr.getNext();

            if (type.equals("age")){
                swapped = this.sortByAge(next, curr, curr.prev, swapped);
            } else if (type.equals("name")) {
                swapped = this.sortByName(next, curr, curr.prev, swapped);
            }
        }
    }

    private Boolean sortByAge(DoublyNode next, DoublyNode curr, DoublyNode prev, Boolean swapped){
        while (next != null) {
            if (curr.getData().getAge() > next.getData().getAge()) {
                swapped = true;

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    this.head = next;
                }

                curr.setNext(next.getNext());
                next.setNext(curr);

                DoublyNode temp = curr;
                curr = next;
                next = temp;
            }

            prev = curr;
            curr = curr.getNext();
            next = next.getNext();
        }
        return swapped;
    }

    private Boolean sortByName(DoublyNode next, DoublyNode curr, DoublyNode prev, Boolean swapped){
        while (next != null) {
            if (curr.getData().getName().compareTo(curr.next.getData().getName()) > 0) {
                swapped = true;

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    this.head = next;
                }

                curr.setNext(next.getNext());
                next.setNext(curr);

                DoublyNode temp = curr;
                curr = next;
                next = temp;
            }

            prev = curr;
            curr = curr.getNext();
            next = next.getNext();
        }
        return swapped;
    }
}