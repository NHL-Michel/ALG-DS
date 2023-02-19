package week_three;

import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree(Node root) {
        super(root);
    }

    /**
     * appends data in binary search tree style
     *
     * @param data data to be appended
     * @param current node
     */
    @Override
    public void append(int data, Node current) {

        if (current == null) {
            return;
        }

        // scenario one, set node to left or iterate to left node
        if (data < current.getData()) {
            if (hasLeft(current)) {
                this.append(data, current.getL());
            } else {
                current.setL(new Node(data));
            }
        }

        // scenario two, set node to right or iterate to right node
        if (data > current.getData()) {
            if (hasRight(current)) {
                this.append(data, current.getR());
            } else {
                current.setR(new Node(data));
            }
        }
    }

    /**
     * convert a binary tree to a binary search tree
     * @param n node that holds the data of the binary tree
     */
    public Node convert(Node n){
        // get all data from the binary tree in arraylist format
        ArrayList<Integer> treeData = getTreeData(n, new ArrayList<>());

        // get the avg of all numbers within the array, then set this value as root value
        int avg = getAvg(treeData);
        this.root = new Node(avg);

        // debug : check in what format the data is being retrieved
        System.err.println(treeData);

        // append everything to the root node with the @override append method
        for (Integer td : treeData) {
            this.append(td, this.root);
        }

        // return the new node converted to a binary search tree
        return this.root;
    }

    /**
     * get the tree data from a binary tree, return the data in the form of an arraylist
     * @param n node
     * @param data arraylist of data that is recursively being added with values
     * @return all data from the binary tree returned as an arraylist
     */
    private ArrayList<Integer> getTreeData(Node n, ArrayList<Integer> data){
        if (n != null) {
            data.add(n.getData());
            getTreeData(n.getL(), data);
            getTreeData(n.getR(), data);
        }
        return data;
    }

    /**
     * get the average num in of an arraylist
     * @param data arraylist with integers
     * @return average num of the arraylist
     */
    private int getAvg(ArrayList<Integer> data){
        int result = 0;
        for (Integer d : data) {
            result += d;
        }
        return result / data.size();
    }

    /**
     * search for a specific key in the binary tree
     *
     * @param data value to be searched for
     * @param current current node
     * @return true if a match was found, else false.
     */
    public Boolean search(int data, Node current) {
        if (this.root == null) {
            return false;
        }

        // if current node is not null, continue
        if (current != null) {
            if (data == current.getData()) {
                // match!
                return true;
            } else if (data < current.getData()) {
                // search in binary tree structure left side
                return this.search(data, current.getL());
            } else if (data > current.getData()) {
                // search in binary tree structure right side
                return this.search(data, current.getR());
            }
        }
        // no match has been found
        return false;
    }
}
