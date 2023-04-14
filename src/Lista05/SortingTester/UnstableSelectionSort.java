package Lista05.SortingTester;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class UnstableSelectionSort<T> extends SortingAlgorithm<T> {

	public UnstableSelectionSort(Comparator<? super T> comparator) {
		super(comparator);
	}

	@Override
	public List<T> sort(List<T> list) {
		int size = list.size();
		
		for(int i = 0; i < (size / 2); i++) {
			int smallestIndex = i;
			int largestIndex = size - i - 1;
			for (int j = i; j < size - i; j++) {
				if (compare(list.get(j), list.get(smallestIndex)) < 0) {
					smallestIndex = j;
				}
				if (compare(list.get(j), list.get(largestIndex)) > 0) {
					largestIndex = j;
				}
			}
			swap(list, i, smallestIndex);
			if (largestIndex == i) {
				swap(list, size - i - 1, smallestIndex);
			} else {
				swap(list, size - i - 1, largestIndex);
			}
		}
		
		return list;
	}

}
