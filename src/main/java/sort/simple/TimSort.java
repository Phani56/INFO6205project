package sort.simple;

import util.FileUtil;
import util.Utilities;

import java.util.Arrays;
import java.util.Comparator;



/**
 * Timsort using the default system sort.
 * String comparator is passed for Pinyin comparison.
 */

public class TimSort{

    public static String language = FileUtil.getSortLanguage();

    public static void sort(String[] xs) {

        Comparator<String> stringComparator = Comparator.comparing(Utilities::getPinyinString);

        if (language.equals(FileUtil.SortLanguage.CHINESE.toString()))
            Arrays.sort(xs, stringComparator);
        else Arrays.sort(xs);
    }

}

