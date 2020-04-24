package binarytree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void addNode(Node node) {
        if (node == null)
            return;
        root.addChild(node);
    }

    // vypis InOrder
    public void printInOrder() {
        System.out.println("INORDER:");
        if (root != null)
            inorderRec(root);
    }

    // rekurzivne volanie
    private void inorderRec(Node node) {
        if (node.getLeft() != null)
            inorderRec(node.getLeft());
        System.out.println("     (" + node.getKey() + "): " + node.getValue() + " ");
        if (node.getRight() != null)
            inorderRec(node.getRight());
    }

    // vypis PREORDER
    public void printPreOrder() {
        System.out.println("PREORDER:");
        if (root != null)
            preorderRec(root);
    }

    private void preorderRec(Node node) {
        System.out.println("     (" + node.getKey() + "): " + node.getValue() + " ");
        if (node.getLeft() != null)
            preorderRec(node.getLeft());
        if (node.getRight() != null)
            preorderRec(node.getRight());
    }

    // VYPIS POST ORDER
    public void printPostOrder() {
        System.out.println("POSTORDER:");
        if (root != null)
            postorderRec(root);
    }

    // rekurzivne volanie vypisu
    private void postorderRec(Node node) {
        if (node.getLeft() != null)
            postorderRec(node.getLeft());
        if (node.getRight() != null)
            postorderRec(node.getRight());
        System.out.println("     (" + node.getKey() + "): " + node.getValue() + " ");
    }

    public String getValue(int key) {
        Node akt = root;
        while (akt != null) {
            if (akt.getKey() == key) {
                return akt.getValue();
            }
            if (akt.getKey() > key) {
                akt = akt.getLeft();
            } else
                akt = akt.getRight();
        }
        return null;
    }


    public boolean containsKey(int key) {
        Node akt = root;
        while (akt != null) {
            if (akt.getKey() == key) {
                return true;
            }
            if (akt.getKey() > key) {
                akt = akt.getLeft();
            } else
                akt = akt.getRight();
        }
        return false;
    }


    public void remove(Node node) {
        // 1 moznost , node je list:
        if (node.isLeaf()) {
            Node parrent = getParrent((node));
            if (parrent == null)
                return;
            if (parrent.getLeft() == node)
                parrent.setLeft(null);
            else
                parrent.setRight(null);
            return;
        }

        // node ma jedneho potomka - praveho
        if (node.getLeft() == null && node.getRight() != null) {
            Node parrent = getParrent(node);
            if (parrent == null)
                return;
            if (parrent.getLeft() == node) {
                parrent.setLeft(node.getRight());

            } else
                parrent.setRight(node.getRight());
        }
        // node ma jedneho potomka - lavy
        if (node.getLeft() != null && node.getRight() == null) {
            Node parrent = getParrent(node);
            if (parrent == null)
                return;
            if (parrent.getLeft() == node) {
                parrent.setLeft(node.getLeft());

            } else
                parrent.setRight(node.getLeft());
        }
    }

    public List<Node> getListOfLeafs() {
        List<Node> list = new ArrayList<>();
        getListOfLeafsRec(root, list);
        return list;
    }

    private void getListOfLeafsRec(Node node, List<Node> list) {
        if (node.isLeaf())
            list.add(node);
        else {
            if (node.getLeft() != null)
                getListOfLeafsRec(node.getLeft(), list);
            if (node.getRight() != null)
                getListOfLeafsRec(node.getRight(), list);
        }
    }

    public int getHeight() {
        if (root == null)
            return -1;

        if (root.isLeaf())
            return 0;

        int max = 0;
        max = getHeightRec(-1, max, root);
        return max;
    }

    private int getHeightRec(int i, int max, Node node) {
        i++;
        if (node.isLeaf()) {
            if (i > max)
                max = i;
            return max;
        }
        if (node.getLeft() != null)
            max = getHeightRec(i, max, node.getLeft());
        if (node.getRight() != null)
            max = getHeightRec(i, max, node.getRight());
        return max;
    }


    public Node getParrent(Node node) {
        if (node == root) {
            return null;
        }

        Node akt = root;
        while (akt != null) {
            if (akt.getLeft() == node)
                return akt;
            if (akt.getRight() == node)
                return akt;
            if (akt.getKey() > node.getKey())
                akt = akt.getLeft();
            else
                akt = akt.getRight();

        }
        return null;
    }

    public Node getMinRightNode(Node node) {
        if (node.isLeaf())
            return null;

        if (node.getRight() == null)
            return null;
        Node akt = node.getRight();
        for (; ; ) {
            if (akt.getLeft() == null)
                return akt;
            else
                akt = akt.getLeft();
        }
    }
}
