package Lista02.Zad1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Array2Iterator<T> implements Iterator<T> {
    private final Array2<T> array2;
    private int arrayIndex;
    private int itemIndex;

    public Array2Iterator(Array2<T> array2) {
        this.array2 = array2;
        this.arrayIndex = 0;
        this.itemIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return arrayIndex < array2.length && itemIndex < array2.getSubarrayLength(arrayIndex);
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            T objectToReturn = array2.get(arrayIndex, itemIndex++);
            if (itemIndex >= array2.getSubarrayLength(arrayIndex)) {
                arrayIndex++;
                itemIndex = 0;
            }
            return objectToReturn;
        }
        throw new NoSuchElementException();
    }
}
