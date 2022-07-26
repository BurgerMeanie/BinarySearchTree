import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @org.junit.jupiter.api.Test
    void testInsert() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(101);
        tree.insert(141);

        assertEquals(100, tree.root.data);
        assertEquals(50, tree.root.left.data);
        assertEquals(150, tree.root.right.data);
    }

    @Test
    void testInOrder() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(100);
        tree.insert(50);
        tree.insert(150);
        tree.insert(101);
        tree.insert(141);

        assertEquals("50 100 101 141 150 ", tree.inOrderTraversal());
    }
}