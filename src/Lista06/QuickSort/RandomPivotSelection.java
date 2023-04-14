package Lista06.QuickSort;

import java.util.Random;

public class RandomPivotSelection implements PivotSelection{
    @Override
    public int select(int startIndex, int endIndex) {
        Random random = new Random();
        return startIndex + random.nextInt(endIndex - startIndex);
    }
}
