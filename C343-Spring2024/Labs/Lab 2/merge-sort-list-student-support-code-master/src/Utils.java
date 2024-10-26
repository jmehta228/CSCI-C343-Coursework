public class Utils {

    static Node nth_node(Node list, int n) {
        for (Node curr = list; curr != null; curr = curr.next)
            if (n == 0)
                return curr;
            else
                --n;
        return null;
    }

    static boolean equals(Node N1, Node N2) {
        while (N1 != null && N2 != null) {
            if (N1.data != N2.data)
                return false;
            N1 = N1.next; N2 = N2.next;
        }
        return N1 == null && N2 == null;
    }

    static Node append(Node N1, Node N2) {
        if (N1 == null)
            return N2;
        else {
            return new Node(N1.data, append(N1.next, N2));
        }
    }

    static Node copy(Node N) {
        if (N == null)
            return null;
        else
            return new Node(N.data, copy(N.next));
    }

    static boolean contains(Node N, int x) {
        if (N == null)
            return false;
        else if (N.data == x)
            return true;
        else
            return contains(N.next, x);
    }

    static Node remove(Node N, int x) {
        if (N == null)
            return null;
        else if (N.data == x) {
            return N.next;
        } else {
            return new Node(N.data, remove(N.next, x));
        }
    }

    static Node array_to_list(int[] array) {
        Node list = null;
        for (int i = array.length - 1; i != -1; --i)
            list = new Node(array[i], list);
        return list;
    }

    static int length(Node list) {
        if (list == null)
            return 0;
        else
            return 1 + length(list.next);
    }

    static int range_length(Node begin, Node end) {
        if (begin == end)
            return 0;
        else
            return 1 + range_length(begin.next, end);
    }

    static Node copy_range(Node begin, Node end) {
        if (begin == end)
            return null;
        else
            return new Node(begin.data, copy_range(begin.next, end));
    }

    // Copy the first n nodes of the list.
    static Node take(Node N, int n) {
        if (n == 0 || N == null)
            return null;
        else {
            return new Node(N.data, take(N.next, n - 1));
        }
    }

    // Return the nth node of the list.
    static Node drop(Node N, int n) {
        if (n == 0 || N == null)
            return N;
        else {
            return drop(N.next, n - 1);
        }
    }

    static int[] list_to_array(Node N) {
        int[] A = new int[length(N)];
        for (int i = 0; i != A.length; ++i) {
            A[i] = N.data;
            N = N.next;
        }
        return A;
    }

    static void remove_next(Node n) {
        if (n.next != null)
            n.next = n.next.next;
    }

    static void insert_after(Node node, int x) {
        Node n = new Node(x, node.next);
        node.next = n;
    }

    static boolean is_sorted(Node N) {
        if (N == null || N.next == null) {
            return true;
        } else {
            return N.data <= N.next.data && is_sorted(N.next);
        }
    }

    static boolean is_permutation(Node N1, Node N2) {
        if (N1 == null) {
            return (N2 == null);
        } else if (contains(N2, N1.data)) {
            return is_permutation(N1.next, remove(N2, N1.data));
        } else {
            return false;
        }
    }
}
