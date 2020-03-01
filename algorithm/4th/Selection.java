package Algorithm4th;

/**
 * @Time : 2020年3月1日21:06:07
 * @Author : yyw@ustc
 * @E-mail : yang0@mail.ustc.edu.cn
 * @Github : https://github.com/ustcyyw
 * @desc : 选择排序
 */
public class Selection {
    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length - 1; i++){
            int k = i + 1;
            for(int j = k; j < a.length; j++){
                if(less(a[j], a[k]))
                    k = j;
            }
            exch(a, i, k);
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
