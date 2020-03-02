package Algorithm4th;

/**
 * @Time : 2020年3月2日16:06:17
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 三向切分的快速排序，对于值大量重复的数组 效率很高，线性级别
 */
public class Quick3Sort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            int cmp = a[lo].compareTo(a[i]);
            if (cmp < 0) exch(a, i, gt--);
            else if (cmp > 0) exch(a, i++, lt++);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
