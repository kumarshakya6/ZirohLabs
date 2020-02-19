package org.datastructure.sort;

public class Main {
	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 7, 8, 12, 13, 14, 15, 16, 111 };

		Search s = new Search();
		int index = Math.abs(s.binarySearch(arr, 2) + 1);

		System.out.println(index);

	}
}
