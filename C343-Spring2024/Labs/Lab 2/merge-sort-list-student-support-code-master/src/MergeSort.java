import java.util.*;

public class MergeSort {

    static Node merge(Node A, Node B) {
        if (A == null) {
            return B;
        }
        else if (B == null) {
            return A;
        }
        Node head;
        Node curr;
        if (A.data <= B.data) {
            head = new Node(A.data, null);
            A = A.next;
        }
        else {
            head = new Node(B.data, null);
            B = B.next;
        }
        curr = head;
        while (A != null && B != null) {
            if (A.data <= B.data) {
                curr.next = new Node(A.data, null);
                A = A.next;
            }
            else {
                curr.next = new Node(B.data, null);
                B = B.next;
            }
            curr = curr.next;
        }


        if (A != null) {
            while (A != null) {
                curr.next = new Node(A.data, null);
                A = A.next;
                curr = curr.next;
            }
        }
        if (B != null) {
            while (B != null) {
                curr.next = new Node(B.data, null);
                B = B.next;
                curr = curr.next;
            }
        }
        return head;
    }

    static Node sort(Node N) {
        if (N == null || Utils.length(N) == 1) {
            return N;
        }
        int nodeLength = Utils.length(N);
        Node firstHalf = Utils.copy_range(Utils.nth_node(N, 0), Utils.nth_node(N, (nodeLength / 2)));
        Node secondHalf = Utils.copy_range(Utils.nth_node(N, nodeLength / 2), Utils.nth_node(N, nodeLength));

        Node sortedFirst = sort(firstHalf);
        Node sortedSecond = sort(secondHalf);
        return merge(sortedFirst, sortedSecond);
    }

    static Node merge_in_place(Node A, Node B) {
        // YOUR CODE GOES HERE
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        Node head;
        if (A.data <= B.data) {
            head = A;
            A = A.next;
        }
        else {
            head = B;
            B = B.next;
        }
        Node curr = head;
        while (A != null && B != null) {
            if (A.data <= B.data) {
                curr.next = A;
                A = A.next;
            }
            else {
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }
        if (A != null) {
            curr.next = A;
        }
        else {
            curr.next = B;
        }
        return head;
    }

    static Node sort_in_place(Node N) {
        // YOUR CODE GOES HERE
        if (N == null || N.next == null) {
            return null;
        }
        Node prev = N;
        Node curr = N.next;
        while (curr != null) {
            curr = curr.next;
            if (curr != null) {
                prev = prev.next;
                curr = curr.next;
            }
        }
        Node firstHalf = N;
        Node secondHalf = prev.next;
        prev.next = null;

        Node sortedFirstHalf = sort_in_place(firstHalf);
        Node sortedSecondHalf = sort_in_place(secondHalf);

        if (sortedFirstHalf == null) { // added
            return sortedSecondHalf;
        }
        else if (sortedSecondHalf == null) {
            return sortedFirstHalf;
        }
        return merge_in_place(sortedFirstHalf, sortedSecondHalf);
    }

//        Node firstHalf = N;
//        Node prev = null;
//        Node curr = N;
//        int i = 0;
//        while (curr != null && i < (nodeLength / 2)) {
//            prev = curr;
//            curr = curr.next;
//            i++;
//        }
//        prev.next = null;
//        Node secondHalf = curr;
//
//        Node sortedFirst = sort_in_place(firstHalf);
//        Node sortedSecond = sort_in_place(secondHalf);
//        return merge_in_place(sortedFirst, sortedSecond);

//        Node firstHalf = Utils.copy_range(Utils.nth_node(N, 0), Utils.nth_node(N, (nodeLength / 2)));
//        Node secondHalf = Utils.copy_range(Utils.nth_node(N, nodeLength / 2), Utils.nth_node(N, nodeLength));
//
//        Node sortedFirst = sort_in_place(firstHalf);
//        Node sortedSecond = sort_in_place(secondHalf);
//        return merge_in_place(sortedFirst, sortedSecond);
}