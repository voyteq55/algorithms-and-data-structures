package Lista06.QuickSort;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPivotSelection<T> implements PivotSelection<T> {
    @Override
    public int select(int startIndex, int endIndex) {
        Random random = new Random();
        return startIndex + random.nextInt(endIndex - startIndex);
    }

    @Override
    public T select(List<T> list) {
        Iterator<T> iterator = list.iterator();
        Random random = new Random();
        int numberOfElementsSoFar = 1;
        T randomElement = null;

        while(iterator.hasNext()) {
            int randomNumber = random.nextInt(numberOfElementsSoFar++);
            T currentElement = iterator.next();
            if (randomNumber == 0) {
                randomElement = currentElement;
            }
        }

        return randomElement;
    }


}
