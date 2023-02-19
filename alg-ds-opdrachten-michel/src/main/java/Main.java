import week_three.BinarySearchTree;
import week_three.BinaryTree;
import week_three.Node;

// https://yongdanielliang.github.io/animation/web/BST.html
class Main {
    public static void main(String[]args){
        // ##### start binary tree ##### //
        Node root = new Node(50); // root node
        BinaryTree t = new BinaryTree(root);
        t.append(43, root);
        t.append(42, root);
        t.append(40, root);
        t.append(55, root);
        t.append(52, root);
        // ##### end binary tree ##### //

        System.out.println("");

        // ##### start binary search tree ##### //
        BinarySearchTree bst = new BinarySearchTree(null); // empty root node
        Node bstNode = bst.convert(root); // root node is set in convert method
        bst.inOrder(bstNode);
        if (bst.search(55, bstNode)) {
            System.out.println("[*] Match found! YEET ");
        }
        // ##### end binary search tree ##### //

    }
}
