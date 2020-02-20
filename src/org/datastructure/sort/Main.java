package org.datastructure.sort;

public class Main {
	public static void main(String[] args) {
		int arr[] = { 14, 523, 618, 743, 72, 67, 12, 136, 314, 145, 16, 111 };

		RadixSortUsingCountingSort obj = new RadixSortUsingCountingSort();
		long start = System.nanoTime();

		arr = obj.radixSort(arr);
		long elapsedTime = System.nanoTime() - start;
		System.out.println(elapsedTime);

		System.out.println("Sorted Array..................");
		for (Integer e : arr) {
			System.out.print(e + " ");
		}

		InsertSort s = new InsertSort();
		int index = Search.searchIndex(arr, 15, 0, arr.length);
		System.out.println(index);

//		QuickSort q = new QuickSort();
//		q.quickSort(arr);
//
//		for (Integer e : arr) {
//			System.out.print(e + " ");
//		}
//		System.out.println();

//		Search s = new Search();
//		int index = Math.abs(s.binarySearch(arr, 2) + 1);
//
//		System.out.println(index);

	}
}
