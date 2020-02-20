package org.datastructure.sort;

public class Search {

	public static int searchIndex(int a[], int key, int lowerBound, int upperBound) {

		if (upperBound <= lowerBound) {
			return (key > a[lowerBound]) ? (lowerBound + 1) : lowerBound;
		}

		int mid = (lowerBound + upperBound) / 2;
		if (a[mid] == key) {
			return mid + 1;
		}

		if (a[mid] < key) {
			return searchIndex(a, key, mid + 1, upperBound);
		} else {
			return searchIndex(a, key, lowerBound, mid - 1);
		}

	}

	public void printArray(int arr[]) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

}
