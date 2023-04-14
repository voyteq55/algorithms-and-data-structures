package Lista06;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class IterMergeSort<T> extends SortingAlgorithm<T> {
    public IterMergeSort(Comparator<? super T> comparator) {
        super(comparator);
    }

    @Override
    public List<T> sort(List<T> list) {
        if (list.isEmpty()) {
            return list;
        }

        MyQueue<List<T>> listQueue = new MyQueue<>();
        for (T element: list) {
            List<T> oneElementList = new ArrayList<>();
            oneElementList.add(element);
            listQueue.enqueue(oneElementList);
        }

        List<T> listleft = null, listRight;
        while (!listQueue.isEmpty()) {
            listleft = listQueue.dequeue();
            if (listQueue.isEmpty()) {
                break;
            }
            listRight = listQueue.dequeue();
            listQueue.enqueue(merge(listleft, listRight));
        }

        list.clear();
        list.addAll(listleft);

        return list;
    }

    private List<T> merge(List<T> listLeft, List<T> listRight) {
        List<T> resultList = new ArrayList<>();
        Iterator<T> iteratorLeft = listLeft.iterator();
        Iterator<T> iteratorRight = listRight.iterator();
        T elementLeft = null;
        T elementRight = null;
        boolean listLeftHasElements = iteratorLeft.hasNext();
        boolean listRightHasElements = iteratorRight.hasNext();
        if (listLeftHasElements) {
            elementLeft = iteratorLeft.next();
        }
        if (listRightHasElements) {
            elementRight = iteratorRight.next();
        }

        while (listLeftHasElements && listRightHasElements) {
            if (compare(elementLeft, elementRight) <= 0) {
                resultList.add(elementLeft);
                listLeftHasElements = iteratorLeft.hasNext();
                if (listLeftHasElements) {
                    elementLeft = iteratorLeft.next();
                } else {
                    resultList.add(elementRight);
                }
            } else {
                resultList.add(elementRight);
                listRightHasElements = iteratorRight.hasNext();
                if (listRightHasElements) {
                    elementRight = iteratorRight.next();
                } else {
                    resultList.add(elementLeft);
                }
            }
        }

        while (iteratorLeft.hasNext()) {
            resultList.add(iteratorLeft.next());
        }
        while (iteratorRight.hasNext()) {
            resultList.add(iteratorRight.next());
        }

        return resultList;
    }
}
