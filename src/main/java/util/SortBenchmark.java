package util;

import sort.counting.MSDStringSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class SortBenchmark<T> {

    static int inputSize = 1000000;

    static String inputType = "RANDOM";

    final static LazyLogger logger = new LazyLogger(SortBenchmark.class);

    static Supplier<String[]> wordSupplier = SortBenchmark::getWordsByInput;

    private void benchmarkAlgorithm(String sortAlgorithm, Consumer<T> sortFunc, Supplier<String[]> supplier) {
        for (int i=0; i<5; i++) {
            int runs = 2;
            Benchmark<String[]> benchmarkTimer = new Benchmark_Timer(sortAlgorithm, sortFunc);
            double meanTime = benchmarkTimer.runFromSupplier(supplier, runs);
            logger.info("Mean Time for INPUT_TYPE" + inputType + "and" + " INPUT_SIZE " + inputSize + ": " + meanTime);
            inputSize = inputSize*2;
        }
    }

    static String[] getWordsByInput() {
        logger.info("In get words");
        String[] arr = new String[inputSize];
        String[] sourceArray = FileUtil.getWordArray();
        if (inputSize<=1000000) {
            arr = Arrays.copyOfRange(sourceArray, 0, inputSize);
        } else {
            for (int i=1; i<inputSize/1000000; i++) {
                System.arraycopy(arr, 0, arr, 1000000*i, 1000000);
            }
        }
        if (inputType.equals("PARTIALLY_SORTED")) {
            Arrays.sort(arr, 0,arr.length/2);
        } else if (inputType.equals("REVERSE")) {
            Arrays.sort(arr, Collections.reverseOrder());
        } else if (inputType.equals("SORTED")) {
            Arrays.sort(arr);
        }
        return arr;
    }

    public static void main(String[] args) {
        String[] inputTypes = {"SORTED", "PARTIALLY_SORTED", "REVERSE", "RANDOM"};
        SortBenchmark<String[]> sortBenchmark = new SortBenchmark<>();
        for (String currentInputType: inputTypes) {
            inputType = currentInputType;
            sortBenchmark.benchmarkAlgorithm("MSD Radix sort", MSDStringSort::sort, wordSupplier);
        }
    }

}
