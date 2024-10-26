import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class BinaryTreeTest {

    BinaryTree<Integer> T1;
    BinaryTree<Integer> T2;
    BinaryTree<Integer> T3;
    BinaryTree<Integer> T4;
    BinaryTree<Integer> T5;
    BinaryTree<Integer> T6;

    @BeforeEach
    public void setUp() throws Exception {
        // INIT BINARY TREE T HERE
        T1 = new BinaryTree<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        T2 = new BinaryTree<>(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 19)));
        T3 = new BinaryTree<>(new ArrayList<>(Arrays.asList(8, 3, 10, 1, 6, 14, 4, 7, 13)));
        T4 = new BinaryTree<>(new ArrayList<>(Arrays.asList(8, 3, 10, 1, 14, 6, 4, 13, 7)));
        T5 = new BinaryTree<>(new ArrayList<>(List.of(1)));
        T6 = new BinaryTree<>(new ArrayList<>());
    }

    @Test
    public void test() {
        // DEFINE EACH TEST CASE AS A SEPARATE FUNCTION
        // CALL ALL TEST FUNCTIONS HERE
        first_test();
        last_test();
        nextAncestor_test();
        prevAncestor_test();
        next_test();
        previous_test();
        get_test();
    }

    @Test
    void first_test() {
        assertEquals(T1.getRoot().first().data, 1);
        assertEquals(T2.getRoot().first().data, 1);
    }

    @Test
    void last_test() {
        assertEquals(T1.getRoot().last().data, 7);
        assertEquals(T2.getRoot().last().data, 19);
    }

    @Test
    void nextAncestor_test() {
        assertNull(T3.getRoot().last().nextAncestor());
        assertEquals(T3.getRoot().first().nextAncestor().data, 3);
    }

    @Test
    void prevAncestor_test() {
        assertEquals(T4.getRoot().last().prevAncestor().data, 13);
        assertNull(T3.getRoot().first().prevAncestor());
    }

    @Test
    void next_test() {
        assertEquals(T4.getRoot().next().data, 6);
        assertEquals(T1.getRoot().next().data, 5);
        assertNull(T5.getRoot().next());
    }

    @Test
    void previous_test() {
        assertEquals(T4.getRoot().previous().data, 1);
        assertEquals(T1.getRoot().previous().data, 3);
        assertNull(T5.getRoot().previous());
    }

    @Test
    void get_test() {
        assertEquals(T4.getRoot().next().next().data, 4);
        assertEquals(T1.getRoot().next().next().data, 6);
    }
}
