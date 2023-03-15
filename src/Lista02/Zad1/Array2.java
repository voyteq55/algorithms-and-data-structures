package Lista02.Zad1;

import Lista02.Modyfikacja.Array2SkipIterator;

import java.util.Iterator;

public class Array2<T> implements Iterable<T> {
    private final T[][] bigArray;
    public final int length;

    @SuppressWarnings("unchecked")
    public Array2(int[] subArraysLengths) throws IllegalArgumentException {
        this.length = subArraysLengths.length;
        bigArray = (T[][]) new Object[this.length][];
        for (int i = 0; i < subArraysLengths.length; i++) {
            if (subArraysLengths[i] < 0) {
                throw new IllegalArgumentException("exception raised: invalid argument (" + subArraysLengths[i] + " is not a valid length)");
            }
            bigArray[i] = (T[]) new Object[subArraysLengths[i]];
        }
    }

    public T get(int i, int j) throws IndexOutOfBoundsException{
        if (i < bigArray.length && j < bigArray[i].length) {
            return bigArray[i][j];
        }
        throw new IndexOutOfBoundsException();
    }

    public void set(T newElem, int i, int j) throws IndexOutOfBoundsException {
        if (i < bigArray.length && j < bigArray[i].length) {
            bigArray[i][j] = newElem;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Array2Iterator<>(bigArray);
    }

    public Iterator<T> iterator(int n) {
        return new Array2SkipIterator<>(bigArray, n);
    }
}
