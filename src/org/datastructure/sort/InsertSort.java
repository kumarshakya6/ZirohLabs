
//TODO: complete method srotInsertWithBinarySearch
package org.datastructure.sort;

public class InsertSort {

	void insertSort(int a[]) {
		int n = a.length;

		for (int j = 1; j < n - 1; j++) {
			int key = a[j];
			int i = j - 1;
			while (i > 0 && key < a[i]) {
				a[i + 1] = a[i];
			}
			a[i + 1] = key;
		}

	}

	void insertUsingBinarySearch(int array[], int n) {
		int i, index, j, selected;

		for (i = 1; i < n; ++i) {
			j = i - 1;
			selected = array[i];

			// Find location where selected should be inserted
			index = Search.searchIndex(array, selected, 0, j);

			// Move all elements after location to create space
			while (j >= index) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = selected;
		}
	}

}
