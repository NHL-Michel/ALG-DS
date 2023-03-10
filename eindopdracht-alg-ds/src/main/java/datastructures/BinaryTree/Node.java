package datastructures.BinaryTree;

import assets.dataset.Person;

public class Node {
    private Node left;
    private Node right;
    private Person data;

    public Node(Person data) {
        this.data = data;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Person getData() {
        return this.data;
    }

    public void setData(Person data) {
        this.data = data;
    }
}
