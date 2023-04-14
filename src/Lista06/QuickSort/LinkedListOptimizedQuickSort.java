package Lista06.QuickSort;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.*;

public class LinkedListOptimizedQuickSort<T> extends SortingAlgorithm<T> {
    PivotSelection pivotSelector;

    public LinkedListOptimizedQuickSort(Comparator<? super T> comparator, PivotSelection pivotSelection) {
        super(comparator);
        this.pivotSelector = pivotSelection;
    }

    @Override
    public List<T> sort(List<T> list) {
        ArrayList<T> newList = new ArrayList<>(list);
        quicksort(newList, 0, list.size());
        list.clear();
        list.addAll(newList);
        return list;
    }

    public void quicksort(List<T> list, int indexStart, int indexEnd) {
        if (indexEnd - indexStart > 1) {
            int indexPivot = partition(list, indexStart, indexEnd);
            quicksort(list, indexStart, indexPivot);
            quicksort(list, indexPivot + 1, indexEnd);
        }
    }

    public int partition(List<T> list, int indexStart, int indexEnd) {
        int pivotIndex = pivotSelector.select(indexStart, indexEnd);
        T pivotValue = list.get(pivotIndex);
        swap(list, indexStart, pivotIndex);

        int targetIndex = indexStart;
        for (int passIndex = indexStart + 1; passIndex < indexEnd; passIndex++) {
            if (compare(list.get(passIndex), pivotValue) <= 0) {
                targetIndex++;
                swap(list, passIndex, targetIndex);
            }
        }

        swap(list, targetIndex, indexStart);

        return targetIndex;
    }
}
