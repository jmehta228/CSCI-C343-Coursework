import org.junit.jupiter.api.Test;
//import sequences.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Test
    public void test() {
        // your tests go here
        small_quickSort_test_1();
        medium_quickSort_test_1();
        large_quickSort_test_1();
        empty_quickSort_test_1();
        one_element_quickSort_test_1();
        preSorted_quickSort_test1();
    }

    @Test
    public void small_quickSort_test_1() {
        Integer[] smallArray = {4, 10, 12, 1, 5};
        Integer[] smallArraySorted = smallArray.clone();
        Arrays.sort(smallArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(smallArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(smallArraySorted, smallArray);
    }

    @Test
    public void medium_quickSort_test_1() {
        Integer[] mediumArray = {56, 24, 85, 10, 92, 41, 63, 30, 77, 45, 13, 95, 6, 74, 17, 49, 29, 68, 82, 39, 90, 21, 3, 50, 27, 36, 19, 73, 32, 8, 62, 96, 55, 9, 88, 20, 47, 70, 91, 11, 2, 71, 98, 37, 42, 64, 7, 15, 87, 53, 83};
        Integer[] mediumArraySorted = mediumArray.clone();
        Arrays.sort(mediumArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(mediumArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(mediumArraySorted, mediumArray);
    }

    @Test
    public void large_quickSort_test_1() {
        Integer[] largeArray = {56, 124, 32, 183, 95, 71, 168, 52, 8, 146, 67, 193, 177, 84, 135, 23, 102, 198, 39, 112, 154, 119, 25, 79, 60, 14, 176, 116, 190, 11, 62, 69, 92, 29, 5, 163, 86, 107, 37, 103, 72, 187, 150, 70, 13, 99, 147, 83, 53, 109, 42, 159, 176, 2, 137, 48, 73, 19, 130, 97, 156, 36, 45, 178, 167, 27, 119, 64, 1, 115, 174, 188, 82, 50, 120, 196, 138, 75, 22, 184, 143, 58, 90, 26, 158, 7, 77, 18, 161, 100, 169, 132, 85, 24, 3, 105, 91, 155, 54, 122, 81, 148};
        Integer[] largeArraySorted = largeArray.clone();
        Arrays.sort(largeArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(largeArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(largeArraySorted, largeArray);
    }

    @Test
    public void empty_quickSort_test_1() {
        Integer[] emptyArray = {};
        Integer[] emptyArraySorted = emptyArray.clone();
        Arrays.sort(emptyArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(emptyArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(emptyArraySorted, emptyArray);
    }

    @Test
    public void one_element_quickSort_test_1() {
        Integer[] oneElementArray = {25};
        Integer[] oneElementArraySorted = oneElementArray.clone();
        Arrays.sort(oneElementArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(oneElementArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(oneElementArraySorted, oneElementArray);
    }

    @Test
    public void preSorted_quickSort_test1() {
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] sortedArraySorted = sortedArray.clone();
        Arrays.sort(sortedArraySorted);
        ArraySequence<Integer> arraySequence = new ArraySequence<>(sortedArray);
        QuickSort.quicksort(arraySequence.begin(), arraySequence.end());
        assertArrayEquals(sortedArraySorted, sortedArray);
    }
}