package org.datastructure.sort;

public class RadixSortUsingCountingSort {

	public int[] radixSort(int A[]) {

		int len = A.length;
		int B[] = new int[len];
		// Copy A to B
		for (int i = 0; i < len; i++) {
			B[i] = A[i];
		}
		int max = getMaxValue(A);

		while (max > 0) {
			int count[] = new int[10];
			int out[] = new int[len];
			int D[] = new int[len];

			// Extra line of code
			// System.out.println("Step.............................");

			// Counts last digit and stores it in the count array
			for (int i = 0; i < len; i++) {
				int temp = B[i] % 10;
				count[temp]++;
			}

			// Extra line of code
			// printArray(count);

			// Adding Last value with current value
			for (int i = 1; i < count.length; i++) {
				count[i] += count[i - 1];
			}

			// Extra line of code
			// printArray(count);

			// Arrange the elements in sorted order
			for (int i = len - 1; i >= 0; i--) {
				int temp = B[i] % 10;

				count[temp]--;
				int index = count[temp];
				out[index] = A[i];
				D[index] = B[i] / 10;

			}

			// Extra lines of code
			// printArray(out);
			// printArray(D);

			// Copy all elements into the A from out
			for (int i = 0; i < len; i++) {
				A[i] = out[i];
				B[i] = D[i];
			}

			// Removes last digit of max
			max /= 10;
		}

		return A;

	}

	private int getMaxValue(int A[]) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > max) {
				max = A[i];
			}
		}
		return max;
	}

	void printArray(int A[]) {
		for (int e : A) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

//	public static void main(String[] args) {
////		int a[] = { 10, 20, 89 };
////		RadixSortUsingCountingSort obj = new RadixSortUsingCountingSort();
////		obj.sort(a);
//		int b = -9;
//		b = b / 10;
//
//		System.out.println(b);
//	}
}
