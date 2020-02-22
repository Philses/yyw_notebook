package easy.Tree.Algorithm4th;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time : 2020年2月22日14:16:13
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc :
 */
public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n = 0;
    private int m;
    private SequentialSearchST<Key, Value>[] st = null;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
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
        int i = hash(key);
        return st[i].get(key);
    }

    public void put(Key key, Value val) {
        if (val == null) {
            delete(key);
            return;
        }

        if (n > 8 * m) resize(2 * m);
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    public void delete(Key key) {
        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);
        if (m > INIT_CAPACITY && n < 2 * m) resize(m / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<>();
        for (SequentialSearchST<Key, Value> theST : st) {
            for (Key key : theST.keys())
                q.add(key);
        }
        return q;
    }

    private void resize(int cap) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(cap);
        for (Key key : keys())
            temp.put(key, get(key));
        this.m = temp.m;
        this.st = temp.st;
    }
}
