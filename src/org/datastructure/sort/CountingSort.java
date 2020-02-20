package org.datastructure.sort;

public class CountingSort {
	public void countingSort(int a[], int k) {
		int n = a.length;
		int b[] = new int[n];
		int count[] = new int[k + 1];

		// Counts the frequency of elements and stores it into the count array
		for (int i = 0; i < n; i++) {
			count[a[i]]++;
		}
		// Count array makes contagious frequency array
		for (int i = 1; i <= k; i++) {
			count[i] += count[i - 1];
		}

		// Makes array b with the help of a and count array
		for (int j = n - 1; j >= 0; j--) {

			b[--count[a[j]]] = a[j];

		}

		// Copying all elements to the original array
		for (int i = 0; i < n; i++) {
			a[i] = b[i];
		}

	}

}
