package Algorithm4th;

/**
 * @Time : 2020年3月2日20:04:59
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 索引优先队列
 */
public class IndexMinPQ<Key extends Comparable<Key>> {
    private int[] pq; // 代表堆，值为索引，索引为存放真正元素的数组的缩影
    private int[] qp; // 下标代表元素在keys中的索引，值为该值在堆中的位置。
    private Key[] aux;
    private int n;

    public IndexMinPQ(int c) {
        n = 0;
        pq = new int[c + 1];
        qp = new int[c];
        aux = (Key[]) new Comparable[c];
    }

    public void insert(int k, Key key) {
        if (aux[k] != null) change(k, key);
        if (k >= aux.length) {
            System.out.printf("the index %d is out of range", k);
            return;
        }
        aux[k] = key;
        pq[++n] = k;
        qp[k] = n;
        swim(n);
    }

    public void change(int k, Key key) {
        aux[k] = key;
        swim(qp[k]); // qp[k] k这个索引对应的元素在堆中的位置。现在该元素变了，要重新恢复堆有序
        sink(qp[k]);
    }

    public boolean contains(int k) {
        if (k >= aux.length) {
            System.out.printf("the index %d is out of range", k);
            return false;
        }
        return aux[k] != null;
    }

    public void delete(int k) {
        if (!contains(k)) return;
        aux[k] = null;
        exch(qp[k], n--);
        swim(qp[k]);
        sink(qp[k]);
        qp[k] = 0; // 表示该索引对应的元素在堆中的位置为0，也就是不存在堆中
    }

    public Key min() {
        return aux[pq[1]];
    }

    public int minIndex() {
        return pq[1];
    }

    public int delMin() {
        int res = pq[1];
        delete(res);
        return res;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size(){
        return n;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 参数代表的是堆中的位置
     */
    private boolean less(int i, int j) {
        return aux[pq[i]].compareTo(aux[pq[j]]) < 0;
    }

    /**
     * 参数代表的是堆中的位置。
     * keys数组中元素位置是不移动的这样才能通过索引访问元素
     * 要交换的pq的值，意味着堆i和j位置的元素改变了，要交换索引以表示位置改变
     * 也要改变qp的值，意味着对应到堆中i，j位置的元素的索引改变了。而且总是有 qp[pq[i]] = i
     */
    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
