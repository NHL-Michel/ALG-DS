package week_three;

public class Node {
    private int data;
    private Node l, r;

    public Node(int data){
        this.data = data;
    }

    public Node(int data, Node l, Node r) {
        this.data = data;
        this.l = l;
        this.r = r;
    }

    public Node getL() {
        return this.l;
    }

    public void setL(Node l) {
        this.l = l;
    }

    public Node getR() {
        return this.r;
    }

    public void setR(Node r) {
        this.r = r;
    }

    public int getData() {
        return this.data;
    }
}
