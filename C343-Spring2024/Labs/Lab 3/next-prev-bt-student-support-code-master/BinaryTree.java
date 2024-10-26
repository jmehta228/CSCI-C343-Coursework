import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> implements Sequence<T>, ReverseSequence<T> {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree() {
        root = null;
    }

    private Node build_inorder(ArrayList<T> A, int begin, int end) {
        if (begin == end) {
            return null;
        } else if (begin + 1 == end) {
            return new Node(A.get(begin), null, null, null);
        } else {
            int mid = begin + ((end - begin) / 2);
            Node n = new Node(A.get(mid), null, null, null);
            Node left = build_inorder(A, begin, mid);
            Node right = build_inorder(A, mid + 1, end);
            n.left = left;
            n.right = right;
            if (left != null)
                left.parent = n;
            if (right != null)
                right.parent = n;
            return n;
        }
    }

    // Build a tree from the array, inorder.
    public BinaryTree(ArrayList<T> L) {
        root = build_inorder(L, 0, L.size());
    }

    public BinaryTree(Node r) {
        root = r;
    }

    @Override
    public Iter begin() {
        if (root == null)
            return new Iter(null);
        else
            return new Iter(root.first());
    }

    @Override
    public Iter end() {
        return new Iter(null);
    }

    @Override
    public Iter rbegin() {
        if (root == null)
            return new Iter(null);
        else
            return new Iter(root.last());
    }

    @Override
    public Iter rend() {
        return new Iter(null);
    }

    class Node {
        T data;
        Node left, right, parent;

        public String toString() {
            return data.toString();
        }

        public Node(T d, Node l, Node r, Node p) {
            data = d;
            left = l;
            right = r;
            parent = p;
        }

        // Return the first node wrt. inorder in this subtree.
        public Node first() { // TODO
            // student implements
            // root.toString();
            Node curr = this;

            if (curr == null) {
                return null;
            }

            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        // Return the last node wrt. inorder in this subtree.
        public Node last() { // TODO
            // student implements
            Node curr = this;

            if (curr == null) {
                return null;
            }

            while (curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }

        // Return the first ancestor that is next wrt. inorder
        // or null if there is none.
        public Node nextAncestor() { //TODO
            // student implements
            if (parent != null && this == parent.right) {
                return parent.nextAncestor();
            }
            else {
                return parent;
            }
        }

        // Return the first ancestor that is previous wrt. inorder
        // or null if there is none.
        public Node prevAncestor() { //TODO
            // student implements
            if (parent != null && this == parent.left) {
                return parent.prevAncestor();
            }
            else {
                return parent;
            }
        }

        // Return the next node wrt. inorder in the entire tree.
        public Node next() { //TODO
            // student implements
            Node curr = this;
            if (curr.right == null) {
                return nextAncestor();
            }
            else {
                return curr.right.first();
            }
        }

        // Return the previous node wrt. inorder in the entire tree.
        public Node previous() { //TODO
            Node curr = this;
            if (curr.left == null) {
                return prevAncestor();
            }
            else {
                return curr.left.last();
            }
        }

    }

    class Iter implements Iterator<T>, ReverseIterator<T> {
        private Node curr;

        Iter(Node c) {
                curr = c;
        }
        public String toString() {
            if (curr == null) return "null";
                else return curr.toString();
        }

        @Override
        public T get() { //TODO
            // student implements
            // YOUR CODE
            if (curr != null) {
                return curr.data;
            }
            return null;
        }

        @Override
        public void retreat() { //TODO
            // student implements
            // YOUR CODE
            if (curr != null) {
                curr = curr.previous();
            }
        }

        @Override
        public void advance() { //TODO
            // student implements
            // YOUR CODE
            if (curr != null) {
                curr = curr.next();
            }
        }

        @Override
        public boolean equals(Object other) { //TODO
            // student implements
            // YOUR CODE
            Iter newIter = (Iter) other;
            return this.curr == newIter.curr;
        }

        @Override
        public Iter clone() { //TODO
            // student implements
            // YOUR CODE
            return new Iter(curr);
        }
    }
}