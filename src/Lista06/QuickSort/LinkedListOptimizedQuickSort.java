package Lista06.QuickSort;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.*;

public class LinkedListOptimizedQuickSort<T> extends SortingAlgorithm<T> {
    PivotSelection<T> pivotSelector;

    public LinkedListOptimizedQuickSort(Comparator<? super T> comparator, PivotSelection<T> pivotSelection) {
        super(comparator);
        this.pivotSelector = pivotSelection;
    }

    @Override
    public List<T> sort(List<T> list) {
        List<T> newList = quicksort(list);
        list.clear();
        list.addAll(newList);
        return list;
    }

    public List<T> quicksort(List<T> list) {
        if (listHasAtMostOneElement(list)) {
            return list;
        }

        T pivotElement = pivotSelector.select(list);

        List<T> smallerThanPivotList = new LinkedList<>();
        List<T> largerThanPivotList = new LinkedList<>();

        for (T element : list) {
            if (element != pivotElement) {
                if (compare(element, pivotElement) < 0) {
                    smallerThanPivotList.add(element);
                } else {
                    largerThanPivotList.add(element);
                }
            }
        }

        List<T> sortedSmallerThanPivotList = quicksort(smallerThanPivotList);
        List<T> sortedLargerThanPivotList = quicksort(largerThanPivotList);

        return mergeListsAndPivot(sortedSmallerThanPivotList, pivotElement, sortedLargerThanPivotList);
    }

    private List<T> mergeListsAndPivot(List<T> leftList, T pivot, List<T> rightList) {
        List<T> mergedList = new LinkedList<>();
        mergedList.addAll(leftList);
        mergedList.add(pivot);
        mergedList.addAll(rightList);
        return mergedList;
    }

    private boolean listHasAtMostOneElement(List<T> list) {
        if (list.isEmpty()) {
            return true;
        }
        Iterator<T> iterator = list.iterator();
        iterator.next();
        return !iterator.hasNext();
    }
}
