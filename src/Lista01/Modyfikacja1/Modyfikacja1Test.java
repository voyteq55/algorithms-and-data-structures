package Lista01.Modyfikacja1;

import java.util.Arrays;

public class Modyfikacja1Test {
    public static void main(String[] args) {
        int[] input1 = {1, 2, 8, -3, -3, -4, 7, 10, 0};
        Substring output1 = new Substring(0, 3);
        test(input1, output1);

        int[] input2 = {};
        Substring output2 = new Substring(-1, 0);
        test(input2, output2);

        int[] input3 = {1, 1, 1, 1, 1, 1, 1,};
        Substring output3 = new Substring(0, 7);
        test(input3, output3);

        int[] input4 = {1, -1, -2, -3, 10, 0, 5, 6};
        Substring output4 = new Substring(5, 3);
        test(input4, output4);

        int[] input5 = {5, -3};
        Substring output5 = new Substring(0, 1);
        test(input5, output5);

        int[] input6 = null;
        Substring output6 = new Substring(-1, 0);
        test(input6, output6);
    }

    private static void test(int[] input, Substring expectedOutput) {
        System.out.println("input: " + Arrays.toString(input) + ", expected output: " + expectedOutput);
        System.out.println("actual output: " + Modyfikacja1.longestNondecreasingSubstring(input));
        System.out.println();
    }

}
