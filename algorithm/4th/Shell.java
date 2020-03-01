package Algorithm4th;

/**
 * @Time : 2020年3月1日22:26:30
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 希尔排序
 */

/**
 * 希尔排序先通过交换不相邻的元素对数组局部排序将其变为一个部分有序的数组
 * 然后使用插入排序完成最终排序
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++)
                for (int j = i; j - h >= 0 && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            h = h / 3;
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
