package datastructures.BinaryTree;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import datastructures.doublylinkedlist.DoublyNode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree<S> implements DataStructure<S> {

    ArrayList<Person> dataset;
    private Node root;

    public BinaryTree() {
        this.root = null;
        this.dataset = Data.generateRandomPersons(5, 100);
    }

    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p, this.root);
        }
        System.out.println(this.getTreeLayout());
    }

    public ArrayList<Person> getDataset() {
        return this.dataset;
    }

    public String getTreeLayout() {
        if (this.root == null) {
            System.out.println("Tree layout list is empty");
            return null;
        }


        System.out.println("Tree layout: ");

        String treeLayout = this.printInorder(this.root, "", true);
        return treeLayout;
    }

    public String printInorder(Node node, String indent, boolean last) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append(indent);
            if (last) {
                sb.append("└─");
                indent += "  ";
            } else {
                sb.append("├─");
                indent += "│ ";
            }
            sb.append(node.getData().getName()).append("\n");
            sb.append(printInorder(node.getLeft(), indent, false));
            sb.append(printInorder(node.getRight(), indent, true));
        }
        return sb.toString();
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

    public int TreeHeight(Node current) {
        if (current == null) {
            return 0;
        }
        return (this.TreeHeight(current.getLeft()) + 1 + this.TreeHeight(current.getRight()));
    }

    public void add(Person data, Node current) {
        if (current == null) {
            this.root = new Node(data);

            return;
        }

        int rightSize = this.TreeHeight(current.getRight());
        int LeftSize = this.TreeHeight(current.getLeft());

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
    public boolean search(S searchTerm) {
        if (root == null) {
            return false;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node curr = stack.pop();
            Integer age = curr.getData().getAge();
            String name = curr.getData().getName();
            if (age.equals(searchTerm) || name.equals(searchTerm)) {
                return true;
            }

            if (curr.getRight() != null) {
                stack.push(curr.getRight());
            }

            if (curr.getLeft() != null) {
                stack.push(curr.getLeft());
            }
        }

        return false;
    }

    @Override
    public void sort(String type) {

    }
}