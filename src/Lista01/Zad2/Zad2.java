package Lista01.Zad2;

public class Zad2 {
    public static int[][] longestNondecreasingSubstrings(int[] numbers) {
        if (numbers.length == 0) {
            return new int[0][0];
        }
        int nOfSubstrings = 1;
        for (int i = 0; i < (numbers.length - 1); i++) {
            if (numbers[i] > numbers[i+1]) {
                nOfSubstrings++;
            }
        }
        int[][] result = new int[nOfSubstrings][];
        int currentSubstringIndex = 0;
        int currentSubstringLength = 1;
        for (int i = 0; i < numbers.length; i++) {
            if ((i < numbers.length - 1) && (numbers[i] <= numbers[i+1])) {
                currentSubstringLength++;
            } else {
                int[] currentSubstring = new int[currentSubstringLength];
                for (int j = 0; j < currentSubstringLength; j++) {
                    currentSubstring[j] = numbers[i - currentSubstringLength + j + 1];
                }
                result[currentSubstringIndex] = currentSubstring;
                currentSubstringIndex++;
                currentSubstringLength = 1;
            }
        }
        return result;
    }
}
