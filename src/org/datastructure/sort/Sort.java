
//TODO: complete method srotInsertWithBinarySearch
package org.datastructure.sort;

public class Sort {

	int[] insertSort(int a[]) {
		int n = a.length;

		for (int j = 1; j < n - 1; j++) {
			int key = a[j];
			int i = j - 1;
			while (i > 0 && key < a[i]) {
				a[i + 1] = a[i];
			}
			a[i + 1] = key;
		}

		return a;
	}

	int[] srotInsertWithBinarySearch(int a[]) {

		return a;
	}

	public static int searchIndex(int a[], int key, int l, int r) {
		int mid = (l + r) / 2;
		if (a[mid] == key) {
			return mid + 1;
		}
		if (a[mid] < key) {
			return searchIndex(a, key, mid + 1, r);
		} else if (a[mid] > key) {
			return searchIndex(a, key, l, mid - 1);
		}

		return 0;

	}

	public static void printArray(int arr[]) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static int[] countingSort(int a[], int k) {
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
			// count[a[j]]--;
			b[--count[a[j]]] = a[j];

		}

		return b;

	}

}
