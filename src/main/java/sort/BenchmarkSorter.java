package sort;

import sort.counting.LSDStringSort;
import sort.counting.MSDStringSort;
import util.Benchmark_Timer;
import util.UtilFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Supplier;

public class BenchmarkSorter {

    public void MSDsort(String[] words) {

        MSDStringSort.sort(words);
//        System.out.println("After applying MSD sort to telugu characters");
//        for (String s : words)
//            System.out.println(s);
    }

    public void LSDsort(String[] words) {

        LSDStringSort.sort(words);
//        System.out.println("After applying LSD sort to telugu characters");
//        for (String s : words)
//            System.out.println(s);
    }

    public void Timsort(String[] words) {

        Arrays.sort(words);
//        System.out.println("After applying Tim sort to telugu characters");
//        for (String s : words)
//            System.out.println(s);

    }

    public static void main(String[] args) throws IOException {

        BenchmarkSorter benchmarkSorter = new BenchmarkSorter();
        String[] words = UtilFile.teluguWords("/Users/mohithparvataneni/Desktop/PSA_Projects/PSA-Final-Project/INFO6205project/src/main/java/sort/TeluguWords.csv");

        Supplier<String[]> supplier = () -> words;


        Benchmark_Timer<String[]> bTimerLSD = new Benchmark_Timer<>("Benchmark Test", null, benchmarkSorter::LSDsort, null);

        double time = bTimerLSD.runFromSupplier(supplier, 10);
        System.out.println(" Time Taken for LSD: " + time);

        Benchmark_Timer<String[]> bTimerMSD = new Benchmark_Timer<>("Benchmark Test", null, benchmarkSorter::MSDsort, null);

        double time1 = bTimerMSD.runFromSupplier(supplier, 10);
        System.out.println(" Time Taken for MSD: " + time1);

        Benchmark_Timer<String[]> bTimerTim = new Benchmark_Timer<>("Benchmark Test", null, benchmarkSorter::Timsort, null);

        double time2 = bTimerTim.runFromSupplier(supplier, 10);
        System.out.println(" Time Taken for Tim: " + time2);
    }
}
