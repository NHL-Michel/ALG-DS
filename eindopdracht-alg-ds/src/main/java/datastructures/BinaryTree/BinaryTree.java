package datastructures.BinaryTree;

import assets.dataset.Person;
import assets.interfaces.DataStructure;

public class BinaryTree <S> implements DataStructure <S> {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public Boolean hasLeft(Node n) {
        return n.getLeft() != null;
    }

    public Boolean hasRight(Node n) {
        return n.getRight() != null;
    }
    public int THeight(Node current) {
        if (current == null) {
            return 0;
        }
        return (this.THeight(current.getLeft()) + 1 + this.THeight(current.getRight()));
    }

    public void add(Person data, Node current) {
        if (current == null) {
            this.root = new Node(data);

            return;
        }

        int rightSize = this.THeight(current.getRight());
        int LeftSize = this.THeight(current.getLeft());

        if (LeftSize <= rightSize) {
            if (this.hasLeft(current)) {
                this.add(data, current.getLeft());
            } else {
                current.setLeft(new Node(data));
            }
        } else {
            if (this.hasRight(current)) {
                this.add(data, current.getRight());
            } else {
                current.setRight(new Node(data));
            }
        }
    }


    @Override
    public void build() {

    }

    @Override
    public boolean search(S searchterm) {
        return false;
    }

    @Override
    public void sort(String type) {

    }
}