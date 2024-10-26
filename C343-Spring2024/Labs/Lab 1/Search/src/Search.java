public class Search {
    // problem 1
    public static int find_first_true(boolean[] A, int begin, int end) {
        if (A.length == 0) {
            return 0;
        }
        for (int i = begin; i != end; ++i) {
            if (A[i]) {
                return i;
            }
        }
        return end;
    }

    // problem 2
    public static int find_first_equal(int[] A, int x) {
        if (A.length == 0) {
            return 0;
        }
        for (int i = 0; i != A.length; ++i) {
            if (A[i] == x) {
                return i;
            }
        }
        return A.length;
    }

    // problem 3
    public static int find_first_true_sorted(boolean[] A, int begin, int end) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1 && A[0]) {
            return 0;
        }
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (A[mid]) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}