import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentTest {

    @Test
    public void test() {
        test_find_first_true();
        test_find_first_equal();
        test_find_first_true_sorted();
    }

    @Test
    void test_find_first_true() {
        boolean[] array1 = {true, true, false, false, false, false, false, false, true, true};
        assertEquals(0, Search.find_first_true(array1, 0, 5));

        boolean[] array2 = {false, false, false, true, true, true, false, false, false, true};
        assertEquals(3, Search.find_first_true(array2, 1, 6));

        boolean[] array3 = {true, false, false, false, true, false, false, false, false, true};
        assertEquals(9, Search.find_first_true(array3, 5, 10));

        boolean[] array4 = {};
        assertEquals(0, Search.find_first_true(array4, 0, 0));

        boolean[] array5 = {true};
        assertEquals(0, Search.find_first_true(array5, 0, 1));

        boolean[] array6 = {false, false, true, true};
        assertEquals(2, Search.find_first_true(array6, 1, 4));

        boolean[] array7 = {true, false};
        assertEquals(0, Search.find_first_true(array7, 0, 2));

        boolean[] array8 = {false, false, false, false, false, false, false, false, false, false};
        assertEquals(8, Search.find_first_true(array8, 4, 8));
    }

    @Test
    void test_find_first_equal() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, Search.find_first_equal(array1, 1));

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(4, Search.find_first_equal(array2, 5));

        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(9, Search.find_first_equal(array3, 10));

        int[] array4 = {1};
        assertEquals(0, Search.find_first_equal(array4, 1));

        int[] array5 = {1};
        assertEquals(1, Search.find_first_equal(array5, 20));

        int[] array6 = {};
        assertEquals(0, Search.find_first_equal(array6, 20));

        int[] array7 = {1, 1, 1, 1, 2, 3, 3, 2, 2, 1, 1, 1};
        assertEquals(4, Search.find_first_equal(array7, 2));
    }

    @Test
    void test_find_first_true_sorted() {
        boolean[] array1 = {false, false, false, false, true, true, true, true, true, true};
        assertEquals(4, Search.find_first_true_sorted(array1, 0, 9));

        boolean[] array2 = {true, true, true, true, true, true, true, true, true, true};
        assertEquals(0, Search.find_first_true_sorted(array2, 0, 9));

        boolean[] array3 = {false, false, false, false, false, false, false, false, false, true};
        assertEquals(9, Search.find_first_true_sorted(array3, 0, 9));

        boolean[] array4 = {};
        assertEquals(0, Search.find_first_true_sorted(array4, 0, 0));

        boolean[] array5 = {true};
        assertEquals(0, Search.find_first_true_sorted(array5, 0, 1));

        boolean[] array6 = {false};
        assertEquals(1, Search.find_first_true_sorted(array6, 0, 1));

        boolean[] array7 = {false, false, true, true, false, false};
        assertEquals(2, Search.find_first_true_sorted(array7, 1, 5));

        boolean[] array8 = {true, true, true, true, true, true, true, true, true, true};
        assertEquals(4, Search.find_first_true_sorted(array8, 4, 9));

        boolean[] array9 = {false, false, false, true, true, true, true, true, true, true, true, true, true, true, true};
        assertEquals(12, Search.find_first_true_sorted(array9, 12, 15));

        boolean[] array10 = {false, false, false, true, true, true, true, true, true, true, true, true, true, true, true};
        assertEquals(3, Search.find_first_true_sorted(array10, 2, 7));
    }
}