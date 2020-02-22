package easy.Tree.Algorithm4th;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * @Time : 2020年2月22日14:16:58
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 顺序查找的符号表
 */
public class SequentialSearchST<Key, Value> {
    private int n = 0;
    private Node head = null;

    class Node {
        private Key key;
        private Value val;
        private Node next;

        Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (n == 0) throw new NoSuchElementException("ST is empty");
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.key.equals(key))
                return temp.val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.key.equals(key)) {
                temp.val = val;
                return;
            }
        }
        Node oldHead = head;
        head = new Node(key, val);
        head.next = oldHead;
        n++;
    }

    public void delete(Key key) {
        if (n == 0) throw new NoSuchElementException("ST is empty");
        head = delete(head, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        if (x.key.equals(key)) {
            n--;
            return x.next;
        } else {
            x.next = delete(x.next, key);
            return x;
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (Node temp = head; temp != null; temp = temp.next)
            q.add(temp.key);
        return q;
    }
}
