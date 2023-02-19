package week_two;

public class SingleLL {
    Node head;

    private class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
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
            n = n.next;
        }

        return size;
    }

    /**
     * append a new node to the end of the linked list
     *
     * @param data to be set in the linked list
     */
    public void appendNode(String data) {
        Node n = new Node(data);

        // check if it already contains nodes
        if (this.getSize() > 0) {
            // if it does contain atleast the head node, continue
            Node tmp = this.head;
            // while a node is not equal to null, continue to next node
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            // if the last node.next is equal to null, set the last node
            tmp.next = n;
        } else {
            this.head = n;
        }
    }

    /**
     * remove a node from a specific index, if it is inbounds, it will be removed.
     *
     * @param index
     */
    public void removeNode(int index) {
        Node tmp = this.head;
        int count = 0;

        if (tmp == null) {
            return;
        }

        while (tmp.next != null) {
            if (count == index - 1) {
                // set the current node
                Node current = tmp.next;
                // set the current node to the next node
                tmp.next = tmp.next.next;
                // remove the current node
                current.next = null;
                // return
                return;
            }
            tmp = tmp.next;
            count += 1;
        }
    }

    /**
     * inserts a node on a specific index
     *
     * @param index
     */
    public boolean insertNode(int index, String data) {
        Node tmp = this.head;
        Node n = new Node(data);
        int count = 0;

        if (tmp == null) {
            return false;
        }

        if (this.getSize() > 0) {
            while (tmp.next != null) {
                if (count == index - 1) {
                    Node next = tmp.next; // next
                    tmp.next = n; // set the new next
                    tmp.next.next = next;
                    return true;
                }
                tmp = tmp.next;
                count += 1;
            }
        }
        return false;
    }

    /**
     * print all the data that is in the linked list
     */
    public void print() {
        Node tmp = this.head;
        while (tmp.next != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
}
