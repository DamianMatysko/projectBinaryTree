package binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void addChild() {
    }

    @Test
    void isLeaf() {
        assertTrue(new Node(1, "blabla").isLeaf());
    }
}