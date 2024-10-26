public class QuickSort {

    /**
     * TODO
     * @param begin The position of the first element in the sequence to be sorted.
     * @param end   The position that is one-past the last element in the sequence to be sorted.
     * @param <E>   The element type for the sequence.
     */

    public static <E extends Comparable<? super E>> void quicksort(Iterator<E> begin, Iterator<E> end) {
        if (begin.equals(end)) {
            return;
        }
        else {
            Iterator<E> pivotPositionIterator = partition(begin, end);
            quicksort(begin, pivotPositionIterator);

            pivotPositionIterator.advance();
            quicksort(pivotPositionIterator, end);
        }
    }

    public static <E extends Comparable<? super E>> Iterator<E> partition(Iterator<E> begin, Iterator<E> end) {
        E pivotValue = Algorithms.last(begin, end).get();
        Iterator<E> i = begin.clone();
        for (Iterator<E> j = begin.clone(); !j.equals(Algorithms.last(begin, end)); j.advance()) {
            if (j.get().compareTo(pivotValue) <= 0) {
                Algorithms.iter_swap(i, j);
                i.advance();
            }
        }
        Algorithms.iter_swap(i, Algorithms.last(begin, end));
        return i;
    }

}
