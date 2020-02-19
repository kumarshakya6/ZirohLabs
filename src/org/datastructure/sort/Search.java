package org.datastructure.sort;

public class Search {

	public int binarySearch(int a[], int key) {
		int leftBound = 0;
		int rightBound = a.length;
		int mid = -1;
		mid = (leftBound + rightBound) / 2;
		if (mid > 0)
			while (leftBound < rightBound) {

				if (a[mid] == key) {
					return mid;
				} else if (a[mid] < key) {
					leftBound = mid + 1;
				} else {
					rightBound = mid - 1;
				}

				mid = (leftBound + rightBound) / 2;
			}

		return mid;

	}

}
