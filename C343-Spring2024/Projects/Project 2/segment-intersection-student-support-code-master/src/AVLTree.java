import java.util.function.BiPredicate;

/**
 * TODO: This is your second major task.
 * <p>
 * This class implements a height-balanced binary search tree,
 * using the AVL algorithm. Beyond the constructor, only the insert()
 * and remove() methods need to be implemented. All other methods are unchanged.
 */

public class AVLTree<K> extends BinarySearchTree<K> {

    /**
     * Creates an empty AVL tree as a BST organized according to the
     * lessThan predicate.
     */
    public AVLTree(BiPredicate<K, K> lessThan) {
        super(lessThan);
    }

    public boolean isAVL() {
        if (root == null)
            return true;
        else
            return root.isAVL();
    }

    /**
     * TODO
     * Inserts the given key into this AVL tree such that the ordering
     * property for a BST and the balancing property for an AVL tree are
     * maintained.
     */

    public Node insert(K key) {
//        root = super.insert(key);
//        if (root.isAVL()) {
//            return root;
//        }
//        return balance(root);
        Node<K> n = super.insert(key);
        Node<K> c = n;
        while (c != null) {
            c.updateHeight();
            c = c.parent;
        }
        return n;
    }

    /**
     * TODO
     * <p>
     * Removes the key from this BST. If the key is not in the tree,
     * nothing happens.
     */
    public void remove(K key) {
        // delete this line and add your code
//        super.remove(key);
//        balance(super.root);
        Node<K> n = find(key, root, null);
        if (n != null) {
            Node<K> par = n.parent;
            super.remove(key);
            while (par != null) {
                par.updateHeight();
                par = par.parent;
            }
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


    private Node<K> balance(Node<K> node) {
        node.updateHeight();
        if (node.left != null && node.right != null && (node.left.height - node.right.height > 1)) {
            if (node.left.left.height >= node.left.right.height) {
                return rotateLL(node);
            }
            else {
                return rotateLR(node);
            }
        }
        if (node.left != null && node.right != null && (node.left.height - node.right.height < -1)) {
            if (node.right.right.height >= node.right.left.height) {
                return rotateRR(node);
            }
            else {
                return rotateRL(node);
            }
        }
        return node;
    }

    private Node<K> rotateLL(Node<K> node) {
        Node<K> leftOfNode = node.left;
        Node<K> rightOfLeft = leftOfNode.right;

        leftOfNode.right = node;
        node.left = rightOfLeft;

        node.updateHeight();
        leftOfNode.updateHeight();
        return leftOfNode;
    }

    private Node<K> rotateRR(Node<K> node) {
	    Node<K> rightOfNode = node.right;
	    Node<K> leftOfRight = rightOfNode.left;

	    rightOfNode.left = node;
	    node.right = leftOfRight;

	    node.updateHeight();
	    rightOfNode.updateHeight();
	    return rightOfNode;
    }

    private Node<K> rotateLR(Node<K> node) {
	    node.left = rotateRR(node.left);
	    return rotateLL(node);
    }

    private Node<K> rotateRL(Node<K> node) {
	    node.right = rotateLL(node.right);
	    return rotateRR(node);
    }

}
