import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNull;

public class MergeSortTest {

    @Test
    public void test() {
        // DEFINE EACH TEST CASE AS A SEPARATE FUNCTION
        // CALL ALL TEST FUNCTIONS HERE

        merge_test();
        sort_test();
        merge_in_place_test();
        sort_in_place_test();
    }

    @Test
    void merge_test() {
        Node head1 = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        Node head2 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead1 = new Node(1, new Node(2, new Node(2, new Node(3, new Node(5, new Node(6, new Node(7, new Node(8, null))))))));
        assertEquals(MergeSort.merge(head1, head2).toString(), newHead1.toString());
        assertEquals(Utils.length(head1), 4);
        assertEquals(Utils.length(head2), 4);
        assertEquals(Utils.length(newHead1), 8);

        Node head3 = new Node(7, null);
        Node head4 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead2 = new Node(2, new Node(3, new Node(6, new Node(7, new Node(8, null)))));
        assertEquals(MergeSort.merge(head3, head4).toString(), newHead2.toString());

        Node head5 = null;
        Node head6 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead3 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        assertEquals(MergeSort.merge(head5, head6).toString(), newHead3.toString());

        Node head7 = new Node(10, null);
        Node head8 = new Node(20, null);
        Node newHead4 = new Node(10, new Node(20, null));
        assertEquals(MergeSort.merge(head7, head8).toString(), newHead4.toString());

        Node head9 = new Node(20, null);
        Node head10 = new Node(10, null);
        Node newHead5 = new Node(10, new Node(20, null));
        assertEquals(MergeSort.merge(head9, head10).toString(), newHead5.toString());
    }

    @Test
    void sort_test() {
        Node head1 = new Node(5, new Node(2, new Node(7, new Node(1, null))));
        Node sorted = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        assertEquals(MergeSort.sort(head1).toString(), sorted.toString());

        Node head2 = new Node(4, null);
        Node actual2 = new Node(4, null);
        assertEquals(MergeSort.sort(head2).toString(), actual2.toString());

        Node head3 = new Node(0, null);
        Node actual3 = new Node(0, null);
        assertEquals(MergeSort.sort(head3).toString(), actual3.toString());
    }

    @Test
    void merge_in_place_test() {
        Node head1 = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        Node head2 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead1 = new Node(1, new Node(2, new Node(2, new Node(3, new Node(5, new Node(6, new Node(7, new Node(8, null))))))));
        assertEquals(MergeSort.merge_in_place(head1, head2).toString(), newHead1.toString());

        Node head3 = new Node(7, null);
        Node head4 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead2 = new Node(2, new Node(3, new Node(6, new Node(7, new Node(8, null)))));
        assertEquals(MergeSort.merge_in_place(head3, head4).toString(), newHead2.toString());

        Node head5 = null;
        Node head6 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        Node newHead3 = new Node(2, new Node(3, new Node(6, new Node(8, null))));
        assertEquals(MergeSort.merge_in_place(head5, head6).toString(), newHead3.toString());
    }

    @Test
    void sort_in_place_test() {
        Node head1 = new Node(5, new Node(2, new Node(7, new Node(1, null))));
        Node sorted1 = new Node(1, new Node(2, new Node(5, new Node(7, null))));
        assertEquals(MergeSort.sort_in_place(head1).toString(), sorted1.toString());

        Node head2 = new Node(4, null);
        Node sorted2 = new Node(4, null);
        assertEquals(MergeSort.sort_in_place(head2).toString(), sorted2.toString());

        Node head3 = new Node(0, null);
        Node sorted3 = new Node(0, null);
        assertEquals(MergeSort.sort_in_place(head3).toString(), sorted3.toString());

        Node head4 = new Node(5, new Node(2, new Node(3, new Node(2, new Node(8, new Node(7, new Node(6, new Node(1, null))))))));
        Node sorted4 = new Node(1, new Node(2, new Node(2, new Node(3, new Node(5, new Node(6, new Node(7, new Node(8, null))))))));
        assertEquals(MergeSort.sort_in_place(head4).toString(), sorted4.toString());
    }
}