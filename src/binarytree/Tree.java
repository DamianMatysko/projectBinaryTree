package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public void printInOrder() {
        if (root != null)
            root.inorder();
    }

    public void printPreOrder() {
        if (root != null)
            root.preorder();
    }

    public void printPostOrder() {
        if (root != null)
            root.postorder();
    }

    public String getValue(int key) {
        Node akt = root;
        while (akt != null) {
            if (akt.getKey() == key) {
                return akt.getValue();
            }
            if (akt.getKey() > key) {
                akt.getLeft();
            } else {
                akt.getRight();
            }
        }
        return null;
    }

    public boolean containsKey(int key) { //
        Node akt = root;
        while (akt != null) {
            if (akt.getKey() == key) {
                return true;
            }
            if (akt.getKey() > key) {
                akt.getLeft();
            } else {
                akt.getRight();
            }
        }
        return false;
    }

    public void remove(Node node) { // TODO is leaf chyba
    }

    public List<Node> getListOfLeafs() {
        Node akt = root;
        Node parent;
        List<Node> list = new ArrayList<>();
        List<Node> memory = new ArrayList<>();
        /*
        while (akt.getLeft() == null) {
            akt.getLeft();
        }

*/
        if (akt.getLeft() == null && akt.getRight() == null) {//if leaf node
            list.add(akt);
        }
        if (akt.getRight() != null)
            akt.getRight();

        if (akt.getLeft() != null)
            akt.getLeft();



        return list;
    } //

    public int getHeight() {
        return -1;
    } //

    public Node getParrent(Node node){
        if (node==root){
            return null;
        }
        Node akt= root;
        if (akt.getLeft()==node){

        }
        while(akt!=null){
            if (akt.getLeft()==node){
                return akt;
            }
            if (akt.getRight()==node){
                return akt;
            }


        }

        return null;
    }
}
