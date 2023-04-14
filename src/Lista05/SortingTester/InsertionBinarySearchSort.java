package Lista05.SortingTester;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class InsertionBinarySearchSort<T> extends SortingAlgorithm<T> {

	public InsertionBinarySearchSort(Comparator<? super T> comparator) {
		super(comparator);
	}

	@Override
	public List<T> sort(List<T> list) {
		int size = list.size();

		for (int i = 1; i < size; i++) {
			int left = 0;
			int right = i;
			while (right - left > 0) {
				int half = (left + right) / 2;
				if (compare(list.get(half), list.get(i)) > 0) {
					right = half;
				} else {
					left = half + 1;
				}
			}
			for (int j = i; j > left; j--) {
				swap(list, j, j - 1);
			}
		}
		
		return list;
	}

}
