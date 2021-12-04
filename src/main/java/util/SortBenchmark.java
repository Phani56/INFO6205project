package util;

import sort.counting.LSDStringSort;
import sort.counting.MSDStringSort;
import sort.huskySort.PureHuskySort;
import sort.huskySortUtils.HuskyCoderFactory;
import sort.simple.QuickSort_DualPivot;
import sort.simple.TimSort;

import java.text.Collator;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class SortBenchmark<T> {

    static int inputSize = 1000000;

    static String inputType = "RANDOM";

    public static String language = FileUtil.getSortLanguage();

    final static LazyLogger logger = new LazyLogger(SortBenchmark.class);

    static Supplier<String[]> wordSupplier = SortBenchmark::getWordsByInput;

    static int RUNS = 5;

    static int TWO_FOLD_INCREMENTS = 5;

    private void benchmarkAlgorithm(String sortAlgorithm, Consumer<T> sortFunc, Supplier<String[]> supplier) {
        for (int i=0; i<TWO_FOLD_INCREMENTS; i++) {
            int runs = RUNS;
            Benchmark<String[]> benchmarkTimer = new Benchmark_Timer(sortAlgorithm, sortFunc);
            double meanTime = benchmarkTimer.runFromSupplier(supplier, runs);
            logger.info("Mean Time for INPUT_TYPE " + inputType + " and" + " INPUT_SIZE " + inputSize + " : " + meanTime);
            inputSize = inputSize*2;
        }
    }

    static String[] getWordsByInput() {
        String[] arr = new String[inputSize];
        String[] sourceArray = FileUtil.getWordArray();
        if (inputSize<=1000000) {
            arr = Arrays.copyOfRange(sourceArray, 0, inputSize);
        } else {
            for (int i=0; i<inputSize/1000000; i++) {
                System.arraycopy(sourceArray, 0, arr, 1000000*i, 1000000);
            }
        }
        switch (inputType) {
            case "PARTIALLY_SORTED":
                if (language.equals(FileUtil.SortLanguage.CHINESE.toString()))
                    Arrays.sort(arr, 0, arr.length / 2, Collator.getInstance(Locale.CHINA));
                else Arrays.sort(arr, 0, arr.length / 2);
                break;
            case "REVERSE":
                if (language.equals(FileUtil.SortLanguage.CHINESE.toString())) {
                    String[] arrCopy = new String[arr.length];
                    Arrays.sort(arr, Collator.getInstance(Locale.CHINA));
                    for (int i = 1; i < arr.length; i++) {
                        arrCopy[arr.length - i - 1] = arr[i];
                    }
                    arrCopy[arr.length - 1] = arr[0];
                    arr = arrCopy;
                }
                Arrays.sort(arr, Collections.reverseOrder());
                break;
            case "SORTED":
                if (language.equals(FileUtil.SortLanguage.CHINESE.toString()))
                    Arrays.sort(arr, Collator.getInstance(Locale.CHINA));
                else Arrays.sort(arr);
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] inputTypes = {"REVERSE", "PARTIALLY_SORTED", "SORTED", "RANDOM"};
        SortBenchmark<String[]> sortBenchmark = new SortBenchmark<>();

        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            inputSize = 250000;
            sortBenchmark.benchmarkAlgorithm("MSD Radix sort", MSDStringSort::sort, wordSupplier);
        }

        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            inputSize = 250000;
            sortBenchmark.benchmarkAlgorithm("LSD Radix sort", LSDStringSort::sort, wordSupplier);
        }

        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            inputSize = 250000;
            sortBenchmark.benchmarkAlgorithm("Tim sort", TimSort::sort, wordSupplier);
        }

        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            inputSize = 250000;
            sortBenchmark.benchmarkAlgorithm("Dual Pivot Quick Sort", QuickSort_DualPivot::sort, wordSupplier);
        }

        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            inputSize = 250000;
            PureHuskySort pureHuskySort = new PureHuskySort(HuskyCoderFactory.utf8Coder, false, true);
            sortBenchmark.benchmarkAlgorithm("MSD Radix sort", pureHuskySort::sort, wordSupplier);
        }

//        String[] teluguWords = getWordsByInput();
//        String[] sortedteluguWords = getWordsByInput();
//        long start = System.currentTimeMillis();
//        QuickSort_DualPivot.sort(teluguWords);
//        long second = System.currentTimeMillis();
//        logger.info("Quicksort time" + (second-start));
//        TimSort.sort(sortedteluguWords);
//        long third = System.currentTimeMillis();
//        logger.info("Quicksort time" + (third-second));
//        int c = 0;
//        for (int i = 0; i < teluguWords.length; i++) {
//            if (!teluguWords[i].equals(sortedteluguWords[i])) {
//                c++;
//            }
//        }
//        System.out.println(c);
    }

}
