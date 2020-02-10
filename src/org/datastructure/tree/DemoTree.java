package org.datastructure.tree;

import java.util.List;

public class DemoTree {

	public static void main(String[] args) throws TreeIsEmptyException {

//		Scanner scan = new Scanner(System.in);
//
//		String str[] = scan.nextLine().split(" ");
//		BinaryRadixTree obj = new BinaryRadixTree();
//
//		for (int i = 0; i < str.length; i++) {
//			obj.insert(str[i]);
//		}
//
//		List<String> result = obj.getPreOrder();
//		for (String s : result) {
//			System.out.print(s + " ");
//		}
//		System.out.println();
//
//		System.out.println(obj.search("11"));

		// using Utility class
		// for Testing

//		System.out.println(Utility.isPrime(11));
//		System.out.println(Utility.isPrime(20));
//
//		System.out.println(Utility.isPrime(23));
//		System.out.println(Utility.isPrime(35343421));

		BinarySearchTree obj = new BinarySearchTree();

		obj.insert(12);
		obj.insert(5);
		obj.insert(20);
		obj.insert(17);
		// obj.insert(0);
		obj.insert(10);
		obj.insert(100);
		obj.insert(110);
		obj.insert(130);
		obj.insert(1);
		obj.insert(17);
		obj.insert(110);
		obj.insert(130);
		obj.insert(1);
		List<Integer> arr = obj.getInOrder();
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
		System.out.println(obj.getLargestSumOfBranch());

//		System.out.println("\n" + arr.length);
//		int temp = obj.getNumOfBranches_K_Height(2);
//		System.out.println(temp);

	}

}
