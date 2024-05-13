import java.util.ArrayList;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    //insert a key-value pair
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    //recursively insert into the tree
    private Node put(Node x, K key, V val) {
        if (x == null) {
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    //retrieve the value associated with a given key
    public V get(K key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    //delete a node with a given key
    public void delete(K key) {
        root = delete(root, key);
    }

    //recursively delete
    private Node delete(Node x, K key) {
        if (x == null) return null;//base case
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
            size--;
        }
        return x;
    }

    //find the node with the smallest key
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    //delete the node with the smallest key
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    //return an iterable collection of keys in sorted order
    public Iterable<K> iterable() {
        List<K> keys = new ArrayList<>();
        inorder(root, keys);
        return keys;
    }

    //perform in-order traversal and collect keys into a list
    private void inorder(Node x, List<K> keys) {
        if (x == null) return;
        inorder(x.left, keys);
        keys.add(x.key);
        inorder(x.right, keys);
    }
}
