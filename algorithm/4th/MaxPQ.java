package Algorithm4th;

/**
 * @Time : 2020年3月2日17:14:57
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 最大优先队列
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private static int INIT_CAPACITY = 20;
    private Key[] a;
    private int n;
    public MaxPQ(){
        this(INIT_CAPACITY);
    }

    public MaxPQ(int c){
        a = (Key[]) new Comparable[c + 1];
    }

    public MaxPQ(Key[] aux){
        a = (Key[]) new Comparable[aux.length + 1];
        for(Key item : aux)
            insert(item);
    }

    public void insert(Key item){
        a[++n] = item;
        swim(n);
    }

    public Key max(){
        return a[1];
    }

    public Key delMax(){
        Key temp = a[1];
        a[1] = a[n];
        a[n--] = null;
        sink(1);
        return temp;
    }

    public boolean isEmpty(){
        return n == 0;
    }
    public int size(){
        return n;
    }

    private void sink(int k){
        while(k * 2 <= n){
            int j = k * 2;
            if(j < n && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k){
        while(k > 1 && less(k / 2, k)){
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch(int i, int j){
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
