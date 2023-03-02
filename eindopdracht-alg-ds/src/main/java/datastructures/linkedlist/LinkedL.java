package datastructures.linkedlist;

import assets.dataset.data;

import java.util.ArrayList;

public class LinkedL {
    private ArrayList<Integer> dataset;
    private Node head;
    private Node tail;

    public LinkedL() {
        this.dataset = data.generateRandomDataset(8, 500);
    }

    public void build(){

    }

    public ArrayList<Integer> getDataset() {
        return this.dataset;
    }
}
