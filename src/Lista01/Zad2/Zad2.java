package Lista01.Zad2;

public class Zad2 {
    public static int[][] longestNondecreasingSubstrings(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0][];
        }
        int[] substringLengths = new int[numbers.length];
        int numbersOfSubstrings = 1;
        substringLengths[0] = 1;
        int substringIndex = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                substringIndex++;
                numbersOfSubstrings++;
            }
            substringLengths[substringIndex]++;
        }

        int[][] result = new int[numbersOfSubstrings][];
        for (int i = 0; i < numbersOfSubstrings; i++) {
            result[i] = new int[substringLengths[i]];
        }

        int numberIndex = 0;
        substringIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numberIndex >= substringLengths[substringIndex]) {
                substringIndex++;
                numberIndex = 0;
            }
            result[substringIndex][numberIndex] = numbers[i];
            numberIndex++;
        }
        return result;
    }

    public static int[][] longestNondecreasingSubstringsInOneGo(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0][];
        }
        Integer[][] substrings = new Integer[numbers.length][numbers.length];
        int[] substringLengths = new int[numbers.length];
        int substringIndex = 0;
        int numberIndex = 0;
        substrings[0][0] = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                substringLengths[substringIndex] = numberIndex + 1;
                substringIndex++;
                numberIndex = 0;
            } else {
                numberIndex++;
            }
            substrings[substringIndex][numberIndex] = numbers[i];
            if (i == numbers.length - 1){
                substringLengths[substringIndex] = numberIndex + 1;
            }
        }

        int[][] result = new int[substringIndex + 1][];
        substringIndex = 0;
        while (substrings[substringIndex][0] != null) {
            result[substringIndex] = new int[substringLengths[substringIndex]];
            for (int i = 0; i < substringLengths[substringIndex]; i++) {
                result[substringIndex][i] = substrings[substringIndex][i];
            }
            substringIndex++;
        }
        return result;
    }
}
