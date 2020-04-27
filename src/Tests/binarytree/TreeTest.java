package binarytree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeTest {
    @Test
    void addNode() {
        Node node1 = new Node(1, "cube");
        Node node2 = new Node(2, "cube");
        Tree myTree = new Tree(node1);
        myTree.addNode(node2);
        assertEquals(node2, node1.getRight());
    }

    @Test
    void containsKey() {
        Node node1 = new Node(1, "cube");
        Tree myTree = new Tree(node1);
        for (int i=2; i<=500; i++) {
            myTree.addNode(new Node(i, "cube"));
        }
        assertTrue(myTree.containsKey(1));
        assertTrue(myTree.containsKey(150));
        assertTrue(myTree.containsKey(250));
        assertFalse(myTree.containsKey(10000));
        assertFalse(myTree.containsKey(6000));
        assertFalse(myTree.containsKey(501));
    }

    @Test
    void remove() {
        Node node1 = new Node(1, "cube");
        Node node2 = new Node(2, "cube");
        Node node3 = new Node(3, "cube");
        Node node4 = new Node(4, "cube");
        Node node5 = new Node(5, "cube");
        Node node6 = new Node(6, "cube");
        Tree myTree = new Tree(node1);

        node1.setRight(node2);
        node2.setLeft(node3);
        node3.setLeft(node4);
        node4.setLeft(node5);
        node5.setLeft(node6);

        Tree testTree = new Tree(node1);
        node5.setLeft(null);

        myTree.remove(node6);
        //assertSame(myTree, testTree);

    }

    @Test
    void getListOfLeafs() {
        List<Node> list = new ArrayList<>();
        Node node1 = new Node(1, "cube");
        Node node2 = new Node(2, "cube");
        Node node3 = new Node(3, "cube");
        Node node4 = new Node(4, "cube");
        Node node5 = new Node(5, "cube");
        Node node6 = new Node(6, "cube");
        Tree myTree = new Tree(node1);

        node1.setLeft(node2);
        node1.setRight(node3);//3

        node2.setRight(node4);
        node2.setLeft(node5);//

        node4.setRight(node6);


        list.add(node5);
        list.add(node6);
        list.add(node3);//to ukladanie musi byt podla poradia

        assertEquals(list, myTree.getListOfLeafs());
    }

    @Test
    void getHeight() {
        Tree myTree = new Tree(new Node(1, "cube"));
        assertEquals(1, myTree.getHeight());
        myTree.addNode(new Node(2, "cube"));
        assertEquals(2, myTree.getHeight());

        myTree.addNode(new Node(2, "cube"));
        myTree.addNode(new Node(3, "cube"));
        myTree.addNode(new Node(4, "cube"));
        assertEquals(4, myTree.getHeight());

        for (int i=5; i<156; i++) {
            myTree.addNode(new Node(i, "cube"));
        }
        assertEquals(155, myTree.getHeight());

        for (int i=156; i<999999999; i++) {
            myTree.addNode(new Node(i, "cube"));
        }
        assertEquals(999999998, myTree.getHeight());
    }

    @Test
    void getParrent() {
        Node node1 = new Node(1, "cube");
        Node node2 = new Node(2, "cube");
        Node node3 = new Node(3, "cube");
        Node node4 = new Node(4, "cube");
        Node node5 = new Node(5, "cube");
        Node node6 = new Node(6, "cube");

        Tree myTree = new Tree(node1);
        myTree.addNode(node2);
        assertEquals(node1, myTree.getParrent(node2));

        myTree.addNode(node2);
        myTree.addNode(node3);
        myTree.addNode(node4);
        myTree.addNode(node5);
        myTree.addNode(node6);
        assertEquals(node5, myTree.getParrent(node6));
    }

    @Test
    void getMinRightNode() {
        Node node1 = new Node(1, "cube");
        Node node2 = new Node(2, "cube");
        Node node3 = new Node(3, "cube");
        Node node4 = new Node(4, "cube");
        Node node5 = new Node(5, "cube");
        Node node6 = new Node(6, "cube");
        Tree myTree = new Tree(node1);

        node1.setRight(node2);
        node2.setLeft(node3);
        node3.setLeft(node4);
        node4.setLeft(node5);
        node5.setLeft(node6);

        assertEquals(node6, myTree.getMinRightNode(node1));
        assertNull(myTree.getMinRightNode(node2));
    }
}