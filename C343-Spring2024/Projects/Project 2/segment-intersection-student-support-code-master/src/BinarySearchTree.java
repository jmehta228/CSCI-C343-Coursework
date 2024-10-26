import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.lang.Math;

/**
 * TODO: This is your first major task.
 * <p>
 * This class implements a generic unbalanced binary search tree (BST).
 */

public class BinarySearchTree<K> implements OrderedSet<K> {

    /**
     * A Node<K> is a Location (defined in OrderedSet.java), which
     * means that it can be the return value of a search on the tree.
     */

    static class Node<K> implements Location<K> {

        protected K data;
        protected Node left;
        protected Node right;
        protected Node<K> parent;
        protected int height;

        /**
         * Constructs a leaf Node<K> with the given key.
         */
        public Node(K key) {
            this(key, null, null);
        }

        /**
         * TODO
         * <p>
         * Constructs a new Node<K> with the given values for fields.
         */
        public Node(K data, Node<K> left, Node<K> right) { // TODO done
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = null;
            this.height = 0;
            updateHeight();
        }

        /*
         * Provide the get() method required by the Location interface.
         */
        @Override
        public K get() {
            return data;
        }

        /**
         * Return true iff this Node<K> is a leaf in the tree.
         */
        protected boolean isLeaf() {
            return left == null && right == null;
        }

        /**
         * TODO
         * <p>
         * Performs a local update on the height of this Node<K>. Assumes that the
         * heights in the child Node<K>s are correct. Returns true iff the height
         * actually changed. This function *must* run in O(1) time.
         */
        protected boolean updateHeight() {
            int newHeight = 1 + Math.max(get_height(left), get_height(right));
            if (newHeight == height) {
                return false;
            }
            else {
                height = newHeight;
                return true;
            }
        }

        private void updateAncestor() {
            Node<K> current = this.parent;
            while (current != null) {
                current.updateHeight();
                current = current.parent;
            }
        }

        // TODO HELPER METHODS FOR prev/next
        private Location<K> first() {
            if (this.left == null) {
                return this;
            }
            else {
                return this.left.first();
            }
        }

        private Location<K> last() {
            Node<K> curr = this;

            if (curr == null) {
                return null;
            }

            while (curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }

        private Location<K> nextAncestor() {
            // student implements
            if (parent != null && this == parent.right) {
                return parent.nextAncestor();
            }
            else {
                return parent;
            }
        }

        private Location<K> prevAncestor() {
            // student implements
            if (parent != null && this == parent.left) {
                return parent.prevAncestor();
            }
            else {
                return parent;
            }
        }

        /**
         * TODO
         * <p>
         * Returns the location of the Node<K> containing the inorder predecessor
         * of this Node<K>.
         */
        @Override
        public Location<K> previous() {
            Node<K> curr = this;
            if (curr.left == null) {
                return prevAncestor();
            }
            else {
                return curr.left.last();
            }
        }

        /**
         * TODO
         * <p>
         * Returns the location of the Node<K> containing the inorder successor
         * of this Node<K>.
         */
        @Override
        public Location<K> next() {
            Node<K> curr = this;
            if (curr.right == null) {
                return nextAncestor();
            }
            else {
                return curr.right.first();
            }
        }

        public boolean isAVL() {
            int h1, h2;
            h1 = get_height(left);
            h2 = get_height(right);
            return Math.abs(h2 - h1) < 2;
        }

        public String toString() {
            return toStringPreorder(this);
        }

    }

    protected Node<K> root;
    protected int numNodes;
    protected BiPredicate<K, K> lessThan;

    /**
     * Constructs an empty BST, where the data is to be organized according to
     * the lessThan relation.
     */
    public BinarySearchTree(BiPredicate<K, K> lessThan) {
        this.lessThan = lessThan;
    }

    /**
     * TODO
     * <p>
     * Looks up the key in this tree and, if found, returns the
     * location containing the key.
     */
    public Node<K> search(K key) { //TODO done
        Node<K> n = find(key, root, null);
        if (n == null) {
            return null;
        }
        else if (n.data.equals(key)) {
            return n;
        }
        else {
            return null; // returns null if not found
        }
    }

    private Node<K> find(K key, Node<K> current, Node<K> parent) {
        if (current == null) {
            return parent;
        }
        else if (lessThan.test(key, current.data)) {
            return find(key, current.left, current);
        }
        else if (lessThan.test(current.data, key)) {
            return find(key, current.right, current);
        }
        else {
            return current;
        }
    }

    /**
     * TODO
     * <p>
     * Returns the height of this tree. Runs in O(1) time!
     */
    public int height() { //TODO done
        if (root != null) {
            return root.height;
        }
        return -1;
    }

    /**
     * TODO
     * <p>
     * Clears all the keys from this tree. Runs in O(1) time!
     */
    public void clear() { //TODO done
        keys().clear();
    }

    /**
     * Returns the number of keys in this tree.
     */
    public int size() {
        return numNodes;
    }

    /**
     * TODO
     * <p>
     * Inserts the given key into this BST, as a leaf, where the path
     * to the leaf is determined by the predicate provided to the tree
     * at construction time. The parent pointer of the new Node<K> and
     * the heights in all Node<K> along the path to the root are adjusted
     * accordingly.
     * <p>
     * Note: we assume that all keys are unique. Thus, if the given
     * key is already present in the tree, nothing happens.
     * <p>
     * Returns the location where the insert occurred (i.e., the leaf
     * Node<K> containing the key), or null if the key is already present.
     */
    public Node<K> insert(K key) { // TODO done
        Node<K> N = find(key, root, null);
        if (N == null) {
            root = new Node<>(key);
            numNodes = 1;
            return root;
        }
        if (search(key) != null) {
            return null;
        }
        else if (lessThan.test(key, N.data)) {
            Node<K> newNode = new Node<>(key);
            N.left = newNode;
            newNode.parent = N;
            newNode.updateAncestor();
            numNodes++;
            return newNode;
        } else if (lessThan.test(N.data, key)) {
            Node<K> newNode = new Node<>(key);
            N.right = newNode;
            newNode.parent = N;
            newNode.updateAncestor();
            numNodes++;
            return newNode;
        }
        else {
            return null;
        }
    }

    /**
     * Returns a textual representation of this BST.
     */
    public String toString() {
        return toStringPreorder(root);
    }

    /**
     * Returns true iff the given key is in this BST.
     */
    public boolean contains(K key) {
        Node<K> p = search(key);
        return p != null;
    }

    /**
     * TODO
     * <p>
     * Removes the key from this BST. If the key is not in the tree,
     * nothing happens.
     */
    public void remove(K key) { // TODO done
        remove(key, root);
    }

    private void remove(K key, Node<K> node) { // helper function for remove
        Node<K> findNode = find(key, node, null);
        if (findNode == null) {
            return;
        }
        else {
            numNodes--;
            if (findNode.left != null && findNode.right != null) {// findNode has 2 children
                if (findNode.parent == null) { // parent is null --> findNode is tree root
                    Node<K> minNode = findMin(findNode.right);
                    findNode.data = minNode.data;
                    replace(minNode, minNode.right);

                }
                else {
                    Node<K> minNode = findMin(findNode.right);
                    findNode.data = minNode.data;
                    replace(minNode, minNode.right);
                }
            }
            else if (findNode.left != null) { // has left NOT right
                replace(findNode, findNode.left);
            }
            else if (findNode.right != null) { // has right NOT left
                replace(findNode, findNode.right);
            }
            else { // leaf
                replace(findNode, null);
            }
            findNode.updateAncestor();
        }
    }

    private void replace(Node<K> node1, Node<K> node2) {
        if (node1.parent == null) {
            root = node2;
            if (node2 != null) {
                node2.parent = null;
            }
        }
        else {
            if (node1.parent.left == node1) {
                setLeft(node1.parent, node2);
            }
            else if (node1.parent.right == node1) {
                setRight(node1.parent, node2);
            }
        }
    }

    private void setLeft(Node<K> node, Node<K> newNode) {
        node.left = newNode;
        if (newNode != null) {
            newNode.parent = node;
        }
        node.updateHeight();
    }


    private void setRight(Node<K> node, Node<K> newNode) {
        node.right = newNode;
        if (newNode != null) {
            newNode.parent = node;
        }
        node.updateHeight();
    }

    private Node<K> findMin(Node<K> node) { // helper function for removeHelper
        if (node == null) {
            return null;
        }
        else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    /**
     * TODO * <p> * Returns a sorted list of all the keys in this tree.
     */
    public List<K> keys() { // TODO done
        return keysHelper(root);
    }

    private List<K> keysHelper(Node<K> node) {
        List<K> inOrderList = new ArrayList<>();
        if (node == null) {
            return new ArrayList<>();
        }
        inOrderList.addAll(keysHelper(node.left));
        inOrderList.add(node.data);
        inOrderList.addAll(keysHelper(node.right));
        return inOrderList;
    }

    static private <K> String toStringPreorder(Node<K> p) {
        if (p == null) return ".";
        String left = toStringPreorder(p.left);
        if (left.length() != 0) left = " " + left;
        String right = toStringPreorder(p.right);
        if (right.length() != 0) right = " " + right;
        String data = p.data.toString();
        return "(" + data + "[" + p.height + "]" + left + right + ")";
    }


    /**
     * The get_height method returns the height of the Node<K> n, which may be null.
     */
    static protected <K> int get_height(Node<K> n) {
        if (n == null) return -1;
        else return n.height;
    }

}