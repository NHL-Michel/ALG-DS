package datastructures.linkedlist;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import com.github.javafaker.Bool;

import java.util.*;

public class LinkedL <S> implements DataStructure <S> {
    private ArrayList<Person> dataset;
    private Node head;
    private Node tail;

    public LinkedL() {
        this.dataset = Data.generateRandomPersons(4, 100);
    }

    // get the age of a person
    @Override
    public void build(){
        for (Person p : dataset) {
            this.appendNode(p);
        }
    }

    @Override
    public boolean search(S searchTerm) {
        Node n = this.head;

        while (n != null) {
            Person person = n.getData();
            Integer age = n.getData().getAge();
            String name = n.getData().getName();
            if (person.equals(searchTerm) || age.equals(searchTerm) || name.equals(searchTerm)) {
                return true;
            }
            n = n.getNext();
        }
        return false;
    }

    @Override
    public void sort(String type) {
        Node n = this.head;
        while (n != null) {
            n = n.getNext();
        }
    }

    public ArrayList<Person> getDataset() {
        return this.dataset;
    }

    /**
     * append a new node to the end of the linked list
     *
     * @param data to be set in the linked list
     */
    public void appendNode(Person data) {
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

    public String getNodeLayout(){
        Node n = this.head;
        StringBuilder nodeString = new StringBuilder();
        while (n != null) {
            nodeString.append("Name: " + n.getData().getName() + ", age : " + n.getData().getAge() + " > ");
            n = n.getNext();
        }
        nodeString.append("NULL");
        return nodeString.toString();
    }
}
