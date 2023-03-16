package datastructures.doublylinkedlist;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import datastructures.linkedlist.LinkedL;

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
        System.out.println("/////////////////////////");
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
        return nodeString.toString();
    }

    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p);
        }
        System.out.println(this.getNodeLayout());
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

            if (type.equals("age")){
                swapped = this.bubbleSort(curr, "int");

            } else if (type.equals("name")) {
                swapped = this.bubbleSort(curr, "string");
            }

            System.out.println(this.getNodeLayout());
        }


    }

    private Boolean bubbleSort(DoublyNode head, String type){
        Boolean swapped;
        DoublyNode curNode;
        DoublyNode loopNode = null;

        // Checking for empty list
        do
        {
            swapped = false;
            curNode = head;

            while (curNode.next != loopNode)
            {
                if (LinkedL.getComparison(type, curNode))
                {
                    Person t = curNode.data;
                    curNode.data = curNode.next.data;
                    curNode.next.data = t;
                    swapped = true;
                }
                curNode = curNode.next;
            }
            loopNode = curNode;
        } while (swapped);

        return swapped;
    }
}