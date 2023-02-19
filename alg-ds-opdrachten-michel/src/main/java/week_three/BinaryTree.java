package week_three;

public class BinaryTree {
    protected Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * check if the node has a spot filled on the left side
     * @param n node that has to be checked if it has a spot on the left
     * @return if null (empty), return false, else return true
     */
    public Boolean hasLeft(Node n) {
        return n.getL() != null;
    }

    /**
     * check if the node has a spot filled on the right side
     * @param n node that has to be checked if it has a spot on the right
     * @return if null (empty), return false, else return true
     */
    public Boolean hasRight(Node n) {
        return n.getR() != null;
    }

    /**
     * append on basis of the size of the left or right side of the node
     * @param data data to be appended
     * @param current current node, in the first recursive iteration this should normally be the root node
     */
    public void append(int data, Node current) {
        if (current == null) {
            return;
        }

        // binary tree left side size from current node
        int leftSide = this.size(current.getL());

        // binary tree right side size from current node
        int rightSide = this.size(current.getR());

        if (leftSide < rightSide) {
            if (this.hasLeft(current)) {
                this.append(data, current.getL());
            } else {
                current.setL(new Node(data));
            }
        } else {
            if (this.hasRight(current)) {
                this.append(data, current.getR());
            } else {
                current.setR(new Node(data));
            }
        }
    }

    /**
     * get the size of the binary tree (node)
     * @param current current node, this is normally the root node
     * @return size of the binary tree
     */
    public int size(Node current) {
        if (current == null) {
            return 0;
        }
        return (this.size(current.getL()) + 1 + this.size(current.getR()));
    }

    /**
     * preOrder
     * @param current current node that is being read
     */
    public void preOrder(Node current) {
        if (current != null) {
            System.out.println(current.getData());
            this.preOrder(current.getL());
            this.preOrder(current.getR());
        }
    }

    /**
     * inOrder
     * @param current current node that is being read
     */
    public void inOrder(Node current) {
        if (current != null) {
            this.inOrder(current.getL());
            System.out.println(current.getData());
            this.inOrder(current.getR());
        }
    }

    /**
     * postOrder
     * @param current current node that is being read
     */
    public void postOrder(Node current) {
        if (current != null) {
            this.postOrder(current.getL());
            this.postOrder(current.getR());
            System.out.println(current.getData());
        }
    }
}
