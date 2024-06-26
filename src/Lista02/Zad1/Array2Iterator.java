package Lista02.Zad1;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Array2Iterator<T> implements Iterator<T> {
    private final T[][] array2;
    private int arrayIndex;
    private int itemIndex;

    public Array2Iterator(T[][] array2) {
        this.array2 = array2;
        this.arrayIndex = 0;
        this.itemIndex = 0;
        while (arrayIndex < array2.length && this.array2[arrayIndex].length == 0) {
            arrayIndex++;
        }
    }

    @Override
    public boolean hasNext() {
        return arrayIndex < array2.length;
    }

    @Override
    public T next() throws NoSuchElementException {
        if (hasNext()) {
            T objectToReturn = array2[arrayIndex][itemIndex++];
            if (itemIndex >= array2[arrayIndex].length) {
                arrayIndex++;
                itemIndex = 0;
            }
            while (arrayIndex < array2.length && this.array2[arrayIndex].length == 0) {
                arrayIndex++;
            }
            return objectToReturn;
        }
        throw new NoSuchElementException();
    }
}
