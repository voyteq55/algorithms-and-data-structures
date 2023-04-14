package Lista05.SortingTester;

import Lista05.SortingTester.core.SortingAlgorithm;

import java.util.Comparator;
import java.util.List;

public class ShakerSort<T> extends SortingAlgorithm<T> {

	public ShakerSort(Comparator<? super T> comparator) {
		super(comparator);
	}

	@Override
	public List<T> sort(List<T> list) {
		int size = list.size();
		boolean hasSwapped = true;
		
		for (int i = 0; hasSwapped; i++) {
			hasSwapped = false;
			for (int left = i; left < (size - i - 1); left++) {
				int right = left + 1;
				
				if(compare(list.get(left), list.get(right)) > 0) {
					swap(list, left, right);
					hasSwapped = true;
				}
			}
			for (int right = size - i - 2; right > i; right--) {
				int left = right - 1;

				if(compare(list.get(left), list.get(right)) > 0) {
					swap(list, left, right);
					hasSwapped = true;
				}
			}
		}
		
		return list;
	}

}
