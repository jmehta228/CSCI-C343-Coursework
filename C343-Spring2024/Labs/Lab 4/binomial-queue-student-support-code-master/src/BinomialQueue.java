import java.util.function.BiPredicate;

class BinomialHeap<K> {
    K key;
    int height;
    PList<BinomialHeap<K>> children;
    BiPredicate<K, K> lessEq;

    BinomialHeap(K k, int h, PList<BinomialHeap<K>> kids, BiPredicate<K, K> le) {
        this.key = k;
        this.height = h;
        this.children = kids;
        this.lessEq = le;
    }

    public int getListSize(PList<BinomialHeap<K>> binomialHeapPList) {
        int size = 0;
        PList<BinomialHeap<K>> current = binomialHeapPList;
        while (current != null) {
            size++;
            current = PList.getNext(current);
        }
        return size;
    }

    /*
     * @precondition this.height == other.height
     */
    BinomialHeap<K> link(BinomialHeap<K> other) {
        if (this.height != other.height)
            throw new UnsupportedOperationException("attempt to link trees of different height");
        if (lessEq.test(other.key, this.key)) {
            PList<BinomialHeap<K>> kids = PList.addFront(other, this.children);
            return new BinomialHeap<>(this.key, this.height + 1, kids, lessEq);
        } else {
            PList<BinomialHeap<K>> kids = PList.addFront(this, other.children);
            return new BinomialHeap<>(other.key, other.height + 1, kids, lessEq);
        }
    }

    /**
     * TODO
     * <p>
     * The isHeap method checks whether or not the subtree of this node
     * satisfies the heap property.
     */
    boolean isHeap() {
        PList<BinomialHeap<K>> rest = children;
        boolean result = true;
        while (getListSize(rest) != 0) {
            BinomialHeap<K> M = PList.getFirst(rest);
            result = result && M.isHeap() && (lessEq.test(M.key, this.key));
            rest = PList.getNext(rest);
        }
        return result;
    }

    boolean isEmpty() {
        return children == null;
    }

    public String toString() {
        String ret = "(" + key.toString();
        if (children != null)
            ret = ret + " " + children.toString();
        return ret + ")";
    }
}

public class BinomialQueue<K> {
    PList<BinomialHeap<K>> forest;
    BiPredicate<K, K> lessEq;

    public BinomialQueue(BiPredicate<K, K> le) {
        forest = null;
        lessEq = le;
    }

    public int getListSize(PList<BinomialHeap<K>> forestParameter) {
        int size = 0;
        PList<BinomialHeap<K>> current = forestParameter;
        while (current != null) {
            size++;
            current = PList.getNext(current);
        }
        return size;
    }

    public void push(K key) {
        BinomialHeap<K> heap = new BinomialHeap<>(key, 0, null, lessEq);
        this.forest = insert(heap, this.forest);
    }

    public K pop() {
        BinomialHeap<K> max = PList.find_max(this.forest, (h1,h2) -> this.lessEq.test(h1.key, h2.key));
        this.forest = PList.remove(max, this.forest);
        PList<BinomialHeap<K>> kids = PList.reverse(max.children, null);
        this.forest = merge(this.forest, kids);
        return max.key;
    }

    public boolean isEmpty() {
        return forest == null;
    }

    /**
     * TODO
     * The isHeap method returns whether or not the Binomial Queue (a forest of Binomial Trees)
     * satisfies the heap property.
     */
    public boolean isHeap() {
        boolean result = true;
        PList<BinomialHeap<K>> rest = forest;
        while (rest != null) {
            if (PList.getFirst(rest).isHeap()) {
                result = true;
                rest = PList.getNext(rest);
            }
            else {
                result = false;
            }
        }
        return result;
    }

    public String toString() {
        if (this.forest == null)
            return "";
        else
            return this.forest.toString();
    }

    /**********************************
     * Helper functions
     */

    /**
     * TODO
     * The insert method is analogous to binary addition. That is,
     * it inserts the node n into the list ns to produce a new list
     * that is still sorted by height.
     *
     * @param <K> The type of the keys.
     * @param n   The node to insert (must not be null).
     * @param ns  The binomial forest into which to insert, ordered by height. (may be null)
     * @return A new binomial forest that includes the new node.
     */
    static <K> PList<BinomialHeap<K>> insert(BinomialHeap<K> n, PList<BinomialHeap<K>> ns) {
        if (ns == null) {
            return new PList<>(n, null);
        }
        if (PList.getFirst(ns).height < n.height) {
            return new PList<>(PList.getFirst(ns), insert(n, PList.getNext(ns)));
        }
        else if (PList.getFirst(ns).height > n.height) {
            return PList.addFront(n, ns);
        }
        else {
            BinomialHeap<K> linkedBinomialHeap = n.link(PList.getFirst(ns));
            return insert(linkedBinomialHeap, PList.getNext(ns));
        }
    }

    /**
     * TODO
     * The merge method is analogous to the merge part of merge sort. That is,
     * it takes two lists that are sorted (by height) and returns a new list that
     * contains the elements of both lists, and the new list is sorted by height.
     *
     * @param ns1
     * @param ns2
     * @return A list that is sorted and contains all and only the elements in ns1 and ns2.
     */
    static <K> PList<BinomialHeap<K>> merge(PList<BinomialHeap<K>> ns1, PList<BinomialHeap<K>> ns2) {
        if (ns1 == null) {
            return ns2;
        }
        if (ns2 == null) {
            return ns1;
        }
        if (PList.getFirst(ns1).height < PList.getFirst(ns2).height) {
            return PList.addFront(PList.getFirst(ns1), merge(PList.getNext(ns1), ns2));
        }
        else if (PList.getFirst(ns1).height > PList.getFirst(ns2).height) {
            return PList.addFront(PList.getFirst(ns2), merge(ns1, PList.getNext(ns2)));
        }
        else {
            BinomialHeap<K> linkedBinomialHeap = PList.getFirst(ns1).link(PList.getFirst(ns2));
            return merge(PList.addFront(linkedBinomialHeap, null), merge(PList.getNext(ns1), PList.getNext(ns2)));
        }
    }
}
