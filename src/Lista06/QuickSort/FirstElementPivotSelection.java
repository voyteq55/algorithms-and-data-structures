package Lista06.QuickSort;

import java.util.List;

public class FirstElementPivotSelection<T> implements PivotSelection<T> {
    @Override
    public int select(int startIndex, int endIndex) {
        return startIndex;
    }

    @Override
    public T select(List<T> list) {
        return list.get(0);
    }


}
