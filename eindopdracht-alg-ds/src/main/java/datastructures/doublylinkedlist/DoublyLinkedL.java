package datastructures.doublylinkedlist;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import datastructures.linkedlist.LinkedL;

import java.util.ArrayList;

public class DoublyLinkedL<S> implements DataStructure<S> {
    private ArrayList<Person> dataset;
    private DoublyNode head;
    private DoublyNode tail;


    public DoublyLinkedL() {
        this.dataset = Data.generateRandomPersons(5, 100);
        this.head = null;
        this.tail = null;
    }

    public DoublyNode getHead() {
        return this.head;
    }

    public DoublyNode getTail() {
        return this.tail;
    }

    /**
     * add a new node to the end of the list
     *
     * @param value value to be added
     */
    public void add(Person value) {
        //Check if index is out of bounds
        // create new node
        DoublyNode newNode = new DoublyNode(value);

        //if list is empty, head and tail points to newNode
        if (this.head == null) {
            this.head = this.tail = newNode;
            //head's previous will be null
            this.head.setPrev(null);
            //tail's next will be null
            this.tail.setNext(null);
        } else {
            //add newNode to the end of list. tail->next set to newNode
            this.tail.setNext(newNode);
            //newNode->previous set to tail
            newNode.setPrev(this.tail);
            //newNode becomes new tail
            this.tail = newNode;
            //tail's next point to null
            this.tail.setNext(null);
        }
    }

    /**
     * get the size of the doublylinked list
     *
     * @return size of list
     */
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

    /**
     * Get layout of the doublylinked list
     *
     * @return string with layout
     */
    public String getNodeLayout() {
        DoublyNode n = this.head;
        StringBuilder nodeString = new StringBuilder();

        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return null;
        }
        System.out.println("Nodes of doubly linked list: ");
        System.out.println("/////////////////////////");
        while (n != null) {
            if (n.getPrev() == null) {
                System.out.println("prev is: null");
            } else {
                System.out.println("prev is: " + n.getPrev().getData().getName());
            }
            System.out.println("cur is:" + n.getData().getName());
            if (n.getNext() == null) {
                System.out.println("next is: null");
            } else {
                System.out.println("next is: " + n.getNext().getData().getName());
            }
            System.out.println("/////////////////////////");
            //Print each node and then go to next.
            nodeString.append("{Name: " + n.getData().getName() + ", age : " + n.getData().getAge() + "} > ");
            n = n.getNext();
        }
        nodeString.append("NULL");
        return nodeString.toString();
    }

    /**
     * build the Doublylinked list with the dataset
     */
    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p);
        }
        System.out.println(this.getNodeLayout());
    }

    /**
     * search for a person age or name
     *
     * @param searchTerm term to be searched
     * @return true or false
     */
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

    /**
     * calls the bubble sort method on type
     *
     * @param type age or name
     */
    @Override
    public void sort(String type) {
        if (this.head == null || this.head.getNext() == null) {
            return;
        }

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            DoublyNode curr = this.head;

            if (type.equals("age")) {
                swapped = this.bubbleSort(curr, "int");

            } else if (type.equals("name")) {
                swapped = this.bubbleSort(curr, "string");
            }

            System.out.println(this.getNodeLayout());
        }


    }

    /**
     * Bubble sort for Doubly Linked List
     *
     * @param head - head of the list
     * @param type - type of data to sort by name or age
     * @return
     */
    private Boolean bubbleSort(DoublyNode head, String type) {
        Boolean swapped;
        DoublyNode curNode;
        DoublyNode loopNode = null;

        // Checking for empty list
        do {
            swapped = false;
            curNode = head;

            while (curNode.getNext() != loopNode) {
                if (LinkedL.getComparison(type, curNode)) {
                    Person t = curNode.getData();
                    curNode.setData(curNode.getNext().getData());
                    curNode.getNext().setData(t);
                    swapped = true;
                }
                curNode = curNode.getNext();
            }
            loopNode = curNode;
        } while (swapped);

        return swapped;
    }

    /**
     * remove a node from the list
     *
     * @param deleteTerm value to be removed
     */
    public void remove(S deleteTerm) {
        if (this.head == null) {
            return;
        }

        DoublyNode n = this.head;

        while (n != null) {
            Integer age = n.getData().getAge();
            String name = n.getData().getName();
            if (age.equals(deleteTerm) || name.equals(deleteTerm)) {
                if (n.getPrev() == null) {
                    this.head = n.getNext();
                    this.head.setPrev(null);
                } else if (n.getNext() == null) {
                    this.tail = n.getPrev();
                    this.tail.setNext(null);
                } else {
                    n.getPrev().setNext(n.getNext());
                    n.getNext().setPrev(n.getPrev());
                }
            }
            n = n.getNext();
        }
    }
}