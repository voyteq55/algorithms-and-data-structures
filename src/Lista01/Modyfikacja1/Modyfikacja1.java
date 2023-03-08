package Lista01.Modyfikacja1;

public class Modyfikacja1 {
    static Substring longestNondecreasingSubstring(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new Substring(-1, 0);
        }

        int longestLength = 1;
        int positionOfLongestSubstring = 0;
        int currentLength = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i+1]) {
                currentLength = 1;
            } else {
                currentLength++;
            }
            if (currentLength > longestLength) {
                longestLength = currentLength;
                positionOfLongestSubstring = i - currentLength + 2;
            }
        }

        return new Substring(positionOfLongestSubstring, longestLength);
    }
}
