package sort.counting;

import util.FileUtil;
import util.Utilities;

import java.text.Collator;
import java.util.Locale;

/**
 * Modified InsertionSortMSD from HuskySort repository. Changes include configuration of code based on the language
 * CHINESE/PINYIN
 * This is a basic implementation of insertion sort used.
 *
 */
public class InsertionSortMSD {

    public static String language = FileUtil.getSortLanguage();

    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        if (language.equals(FileUtil.SortLanguage.CHINESE.toString())) {
            return Utilities.getPinyinString(v).compareTo(Utilities.getPinyinString(w))<0;
//            return Collator.getInstance(Locale.CHINA).compare(v, w) < 0;
        } else return v.substring(d).compareTo(w.substring(d)) < 0;
    }


    public static void sort(String[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--)
                swap(a, j, j - 1);
    }


    private static boolean less(String v, String w) {
        if (language.equals(FileUtil.SortLanguage.CHINESE.toString())) {
            return Utilities.getPinyinString(v).compareTo(Utilities.getPinyinString(w))<0;
//            return Collator.getInstance(Locale.CHINA).compare(v, w) < 0;
        } else return v.compareTo(w) < 0;
    }



    private static void swap(Object[] a, int j, int i) {
        Object temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


}
