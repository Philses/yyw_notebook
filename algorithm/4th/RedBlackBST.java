package easy.Tree.Algorithm4th;

/**
 * @Time : 2020年2月19日19:32:06
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static boolean RED = true;
    private static boolean BLACK = false;

    class Node{
        private Key key;
        private Value val;
        private int N;
        private boolean color;
        private Node left, right;

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private Node root = null;

    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.N;
    }

    /**
     * 将红色的右链接修正为左链接，其实就是将相对较小的键为根结点，转变为相对较大的键位根结点
     * @param h 键相对较小的节点
     * @return 现对较大的键
     */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    private void flipColor(Node x){
        x.color = RED;
        x.right.color = BLACK;
        x.left.color = BLACK;
    }

    public void put(Key key, Value val){
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val){
        if(x == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(x.key);
        if(cmp < 0) x.left = put(x.left, key, val);
        else if(cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColor(x);

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
