package Lista06.QuickSort;

import java.util.List;

public interface PivotSelection<T> {
    int select(int startIndex, int endIndex);
    T select(List<T> list);
}
