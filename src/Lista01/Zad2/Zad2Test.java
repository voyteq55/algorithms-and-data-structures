package Lista01.Zad2;

import java.util.Arrays;

public class Zad2Test {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 8, -3, -3, -4, 7, 10, 0};
        int[][] output1 = new int[][]{{ 1, 2, 8 }, { -3, -3 }, { -4, 7, 10 }, { 0 }};
        test(input1, output1);

        int[] input2 = {};
        int[][] output2 = new int[][]{};
        test(input2, output2);

        int[] input3 = {1, 1, 1, 1, 1, 1, 1,};
        int[][] output3 = new int[][]{{1, 1, 1, 1, 1, 1, 1,}};
        test(input3, output3);

        int[] input4 = {1, -1, -2, -3, 10, 0, 5, 6};
        int[][] output4 = new int[][]{{1}, {-1}, {-2}, {-3, 10}, {0, 5, 6}};
        test(input4, output4);
    }

    private static void test(int[] input, int[][] expectedOutput) {
        System.out.println(Arrays.deepEquals(Zad2.longestNondecreasingSubstrings(input), expectedOutput));
    }
}
