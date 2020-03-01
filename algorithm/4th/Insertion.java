package Algorithm4th;

/**
 * @Time : 2020年3月1日21:17:36
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 插入排序
 */

/**
 * 当倒置较少时，插入排序可能是最高效的。
 */
public class Insertion {
    public static void sort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
