package org.datastructure.sort;

//Quick InsertSort is Done
//TODO: Quick InsertSort using Binary Search
public class QuickSort {

	public void quick(int A[]) {

	}

	/**
	 * This method a QUICK SORT method with the help of using COUNTING SORT
	 * 
	 * @param A: This A is a integer array which. The user want to SORT that array
	 * @return
	 */
	public void quickSort(int A[]) {

		// Calls the quickSort method for whole array
		quickSort(A, 0, A.length - 1);

	}

	private void quickSort(int A[], int p, int r) {
		if (p < r) {
			// Divides the array into two parts and returns divider Index
			int q = partation(A, p, r);
			// Calls the quick sort method again for Left part of the Division
			quickSort(A, p, q - 1);
			// Calls the quick sort method again for Right part of the Division
			quickSort(A, q + 1, r);

		}
	}

	// This method Divide the array into two parts and returns divider index
	private int partation(int A[], int p, int r) {

		int x = A[r];

		int i = p - 1;

		// This loop runs until J index is less than R
		for (int j = p; j < r; j++) {
			if (A[j] < x) {
				i++;

				swap(A, i, j);

			}
		}
		i++;
		swap(A, i, r);
		return i;

	}

	// This method will swaps value of the Array at indexes on I and J
	private void swap(int A[], int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
