package easy.Tree.Algorithm4th;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time : 2020年2月18日19:45:30
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 算法第四版 二叉查找树的复习
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public boolean contain(Key key){
        return get(key) != null;
    }

    public boolean empty(){
        return root == null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public Key min() {
        if (root == null) return null;
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public Key max() {
        if (root == null) return null;
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key) {
        Node result = floor(root, key);
        return result == null ? null : result.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        else if (cmp == 0) return x;
        else {
            Node temp = floor(x.right, key);
            if (temp != null) return temp;
            else return x;
        }
    }

    public Key ceiling(Key key) {
        Node result = ceiling(root, key);
        return result == null ? null : result.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x.right, key);
        else if (cmp == 0) return x;
        else {
            Node temp = ceiling(x.left, key);
            if (temp != null) return temp;
            else return x;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return size(x.left);
        else if (cmp < 0) return rank(x.left, key);
        else return rank(x.right, key) + size(x.left) + 1;
    }

    public Key select(int k) {
        Node result = select(root, k);
        return result == null ? null : result.key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int i = size(x.left);
        if (i < k) return select(x.right, k - i - 1);
        else if (i > k) return select(x.left, k);
        else return x;
    }

    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x == null) return null;
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x == null) return null;
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
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
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new LinkedList<>();
        keys(q, root, lo, hi);
        return q;
    }

    private void keys(Queue<Key> q, Node x, Key lo, Key hi) {
        if(x == null) return;
        int cmpLeft = lo.compareTo(x.key);
        int cmpRight = hi.compareTo(x.key);
        if(cmpLeft < 0)
            keys(q, x.left, lo, hi);
        if(cmpLeft <= 0 && cmpRight >= 0)
            q.add(x.key);
        if(cmpRight > 0)
            keys(q, x.right, lo, hi);
    }

    class Node {
        private Key key;
        public Value val;
        private Node left, right;
        private int N;

        private Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }
}
