package Algorithm4th;

/**
 * @Time : 2020年3月1日23:30:31
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 归并排序
 */
public class MergeSort {
    private static Comparable[] aux;

    /**
     * 自顶向下的归并排序，其实就是递归 且就像DFS
     */
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { // 排序[lo, hi] 闭区间
        if (lo >= hi)
            return;
        int mid = (hi - lo) / 2 + lo;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 规定两段子数组[0, mid],[mid+1, hi] 都是闭区间
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else if (less(a[i], a[j])) aux[k] = a[i++];
            else aux[k] = a[j++];
        }

        for (int k = lo; k <= hi; k++)
            a[k] = aux[k];
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 自底向上的归并排序，其实就是迭代
     * 就像BFS 一层一层地归并
     */
    public static void sort2(Comparable[] a) {
        int n = a.length;
        for (int l = 1; l < n; l = l * 2) { // l表示用于归并的第一个子数组的长度
            for (int i = 0; i + l < n; i += 2 * l)
                merge(a, i, i + l - 1, Math.min(i + 2 * l - 1, n - 1));
        }
    }
}
