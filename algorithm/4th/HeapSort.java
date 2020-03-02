package Algorithm4th;

/**
 * @Time : 2020年3月2日21:36:35
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 堆排序
 */
public class HeapSort {
    public static void sort(Comparable[] a){
        for(int i = a.length / 2; i > 0; i--)
            sink(a, i);

        for(int i = a.length; i > 0; i--){
            exch(a, i, 1);
            sink(a, 1);
        }
    }

    private static void sink(Comparable[] a, int k) {
        int n = a.length;
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(a, j, j + 1)) j++;
            if (!less(a, k, j)) break;
            exch(a, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }
}
