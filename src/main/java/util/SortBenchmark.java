package util;

import sort.counting.MSDStringSort;

import java.util.function.Supplier;


public class SortBenchmark {

    static Supplier<String[]> wordSupplier = FileUtil::getWordArray;

    public static void main(String[] args) {
        Benchmark<String[]> benchmarkTimer = new Benchmark_Timer<>(MSDStringSort.class.toString(), MSDStringSort::sort);
        benchmarkTimer.runFromSupplier(wordSupplier, 2);
    }


}
