package datastructures.BinaryTree;

import assets.dataset.Data;
import assets.dataset.Person;
import assets.interfaces.DataStructure;
import datastructures.doublylinkedlist.DoublyNode;

import java.util.ArrayList;
import java.util.Stack;

import static datastructures.BinaryTree.ConvertBtTOBst.convertBtToBstForName;
import static datastructures.BinaryTree.ConvertBtTOBst.convertBtToBstForNumbers;

public class BinaryTree<S> implements DataStructure<S> {

    ArrayList<Person> dataset;
    private Node root;
    private String treeLayout;

    public BinaryTree() {
        this.root = null;
        this.dataset = Data.generateRandomPersons(50, 100);
    }

    @Override
    public void build() {
        for (Person p : this.dataset) {
            this.add(p, this.root);
        }
        this.setTreeLayout();
        System.out.println(this.getTreeLayout());
    }

    public ArrayList<Person> getDataset() {
        return this.dataset;
    }

    public void setTreeLayout() {
        if (this.root == null) {
            System.out.println("Tree layout list is empty");
        }
        System.out.println("Tree layout: ");
        this.treeLayout = this.printInorder(this.root, "", true);

    }

    public String getTreeLayout() {

        return this.treeLayout;
    }

    public static String printInorder(Node node, String indent, boolean last) {
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
            sb.append("Name: ").append(node.getData().getName()).append(", Age: ").append(node.getData().getAge()).append("\n");
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
        System.out.println("Tree layout: ");

        if (type.equals("age")){
            this.treeLayout = convertBtToBstForNumbers(this.root);
        } else if (type.equals("name")) {
            this.treeLayout = convertBtToBstForName(this.root);
        }

    }
}