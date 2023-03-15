package Lista02.Modyfikacja;

import Lista02.Zad1.Array2Iterator;

import java.util.Iterator;

public class Array2SkipIterator<T> implements Iterator<T> {

    private int n;
    private T[][] array2;
    private Array2Iterator<T> subIterator;

    public Array2SkipIterator(T[][] array2, int n) throws IllegalArgumentException {
        this.array2 = array2;
        subIterator = new Array2Iterator<>(array2);
        if (n >= 1) {
            this.n = n;
        } else {
            throw new IllegalArgumentException("exception raised: invalid argument (" + n+ " is not a valid step)");
        }
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < n - 1; i++) {
            if (!subIterator.hasNext()) {
                return false;
            }
            subIterator.next();
        }
        return subIterator.hasNext();
    }

    @Override
    public T next() {
        return subIterator.next();
    }

}
