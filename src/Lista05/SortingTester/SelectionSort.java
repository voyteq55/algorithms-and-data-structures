package Lista05.SortingTester;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> extends SortingAlgorithm<T> {

	public SelectionSort(Comparator<? super T> comparator) {
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
				if (compare(list.get(j), list.get(largestIndex)) >= 0) {
					largestIndex = j;
				}
			}
			for (int k = smallestIndex; k > i; k--) {
				swap(list, k, k-1);
			}
			if (smallestIndex >= largestIndex) {
				largestIndex++;
			}
			if (largestIndex == i) {
				for (int k = smallestIndex; k < size - i - 1; k++) {
					swap(list, k, k+1);
				}
			} else {
				for (int k = largestIndex; k < size - i - 1; k++) {
					swap(list, k, k+1);
				}
			}
		}
		
		return list;
	}

}
