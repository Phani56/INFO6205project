package sort.simple;


import sort.counting.InsertionSortMSD;
import util.FileUtil;
import util.Utilities;


/**
 * Modified Dual Pivot Quicksort from textbook. (Algorithms by Robert Sedgewick)
 * Config for input language to handle Pinyin and basic unicode ordering.
 */
public class QuickSort_DualPivot {

    public static String language = FileUtil.getSortLanguage();


    // quicksort the array a[] using dual-pivot quicksort
    public static void sort(String[] a) {
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray a[lo .. hi] using dual-pivot quicksort
    private static void sort(String[] a, int lo, int hi) {
        if (hi <= lo) return;

        // make sure a[lo] <= a[hi]
        if (less(a[hi], a[lo])) exch(a, lo, hi);

        int lt = lo + 1, gt = hi - 1;
        int i = lo + 1;
        while (i <= gt) {
            if       (less(a[i], a[lo])) exch(a, lt++, i++);
            else if  (less(a[hi], a[i])) exch(a, i, gt--);
            else                         i++;
        }
        exch(a, lo, --lt);
        exch(a, hi, ++gt);

        // recursively sort three subarrays
        sort(a, lo, lt-1);
        if (less(a[lt], a[gt])) sort(a, lt+1, gt-1);
        sort(a, gt+1, hi);

    }



    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(String v, String w) {
        if (language.equals(FileUtil.SortLanguage.CHINESE.toString())) return Utilities.getPinyinString(v).compareTo(Utilities.getPinyinString(w))<0;
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    // print array to standard output
    private static void show(String[] a) {
        for (int i = 0; i < 20; i++) {
            System.out.println(a[i]);
        }
    }

    // Read strings from standard input, sort them, and print.
    public static void main(String[] args) {
        String[] a = {"a", "b", "c"};
        try {
            a = FileUtil.getWordArray();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        QuickSort_DualPivot.sort(a);
        show(a);
    }

}

