/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package sort.simple;

import util.FileUtil;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;


public class TimSort{

    public static String language = FileUtil.getSortLanguage();

    public static void sort(String[] xs) {
        if (language.equals(FileUtil.SortLanguage.CHINESE.toString()))
            Arrays.sort(xs, Collator.getInstance(Locale.CHINA));
        else Arrays.sort(xs);
    }

}

