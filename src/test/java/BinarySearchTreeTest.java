package test.java;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    void testInsertAndSearch() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Test search functionality
        Assertions.assertTrue(tree.search(40));
        Assertions.assertFalse(tree.search(100));
    }

    @Test
    void testInorderTraversal() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Expected inorder traversal is 20, 30, 40, 50, 60, 70, 80
        String expectedOutput = "20 30 40 50 60 70 80 ";

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        tree.inorder();
        assertEquals(expectedOutput, outContent.toString());
    }
}
