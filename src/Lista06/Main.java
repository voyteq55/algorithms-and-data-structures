package Lista06;

import java.util.Comparator;

import Lista05.SortingTester.core.SortingAlgorithm;
import Lista05.SortingTester.testing.*;
import Lista05.SortingTester.testing.comparators.*;
import Lista05.SortingTester.testing.generation.*;
import Lista05.SortingTester.testing.generation.conversion.*;
import Lista06.QuickSort.*;

public class Main {

    public static void main(String[] args) {
        int[] numbersOfElements = new int[]{2000, 3000, 4000, 5000, 6000, 7000, 8000, 10000, 12000, 14000, 16000, 18000, 20000, 25000, 30000};
//        int[] numbersOfElements = new int[]{200, 300, 400, 500, 600, 700, 800, 1000, 1200, 1400, 1600, 1800, 2000, 2500, 3000};

        Comparator<MarkedValue<Integer>> markedComparator = new MarkedValueComparator<Integer>(new IntegerComparator());

        Generator<MarkedValue<Integer>> generator = new LinkedListGenerator<>(new MarkingGenerator<>(new ShuffledIntegerArrayGenerator()));
//        Generator<MarkedValue<Integer>> generator = new MarkingGenerator<Integer>(new ShuffledIntegerArrayGenerator());

        SortingAlgorithm<MarkedValue<Integer>> algorithm = new LinkedListOptimizedQuickSort<>(markedComparator, new RandomPivotSelection<>());
//        SortingAlgorithm<MarkedValue<Integer>> algorithm = new IterMergeSort<>(markedComparator);


        for (int numberOfElements : numbersOfElements) {
            Result result = Tester.runNTimes(algorithm, generator, numberOfElements, 20);
            String outputString = numberOfElements +  " " + double2String(result.averageTimeInMilliseconds()) + " " +
                    double2String(result.timeStandardDeviation()) + " " + double2String(result.averageComparisons()) +
                    " " + double2String(result.comparisonsStandardDeviation()) + " " + double2String(result.averageSwaps())
                    + " " + double2String(result.swapsStandardDeviation());
            System.out.println(outputString);
        }

        Result result = Tester.runNTimes(algorithm, generator, 2000, 10);
        printStatistic("time [ms]", result.averageTimeInMilliseconds(), result.timeStandardDeviation());
        printStatistic("comparisons", result.averageComparisons(), result.comparisonsStandardDeviation());
        printStatistic("swaps", result.averageSwaps(), result.swapsStandardDeviation());

        System.out.println("always sorted: " + result.sorted());
        System.out.println("always stable: " + result.stable());
    }

    private static void printStatistic(String label, double average, double stdDev) {
        System.out.println(label + ": " + double2String(average) + " +- " + double2String(stdDev));
    }

    private static String double2String(double value) {
        return String.format("%.12f", value).replace(".", ",");
    }
}
