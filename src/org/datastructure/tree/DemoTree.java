package org.datastructure.tree;

import java.util.List;

public class DemoTree {

	public static void main(String[] args) throws EmptyTreeException {

		AVLTree tree = new AVLTree();
		tree.insert(2);
		tree.insert(5);
		tree.insert(10);
		tree.insert(30);
		tree.insert(45);
		tree.insert(50);
		tree.insert(60);
		System.out.println(tree.getHeight());

		List<Integer> arr = tree.getInOrder();
		for (Integer e : arr) {
			System.out.print(e + " ");

		}
		System.out.println();
		tree.delete(2);
		tree.delete(5);
		tree.insert(45);
		System.out.println(tree.getHeight());

		List<Integer> arr2 = tree.getInOrder();
		for (Integer e : arr2) {
			System.out.print(e + " ");

		}
		System.out.println();

//		String str[] = scan.nextLine().split(" ");
//		BinaryRadixTree obj = new BinaryRadixTree();
//
//		for (int i = 0; i < str.length; i++) {
//			obj.insert(str[i]);
//		}
//
//		List<String> result = obj.getSorted();
//		for (String s : result) {
//			System.out.print(s + " ");
//		}
//		System.out.println();
//
//		System.out.println(obj.search("11"));
//		System.out.println(obj.search("10"));
//		System.out.println(obj.search("1100"));
//		System.out.println(obj.search("101010011"));

		// using Utility class
		// for Testing

//		System.out.println(Utility.isPrime(11));
//		System.out.println(Utility.isPrime(20));
//
//		System.out.println(Utility.isPrime(23));
//		System.out.println(Utility.isPrime(35343421));

		BinarySearchTree obj = new BinarySearchTree();

		obj.insert(2);
		obj.insert(5);
		obj.insert(20);
		obj.insert(27);
		obj.insert(50);

		System.out.println(obj.getHeight());
//		obj.insert(9);
//		obj.insert(40);
//		obj.insert(100);
//		obj.insert(1);
//
//		List<Integer> arr = obj.getInOrder();
//		for (int e : arr) {
//			System.out.print(e + " ");
//		}
//		System.out.println();
//		System.out.println(obj.getLargestSumOfBranch());
//
//		List<Integer> largestSumBranch = obj.getLargestSumBranch();
//		for (Integer e : largestSumBranch) {
//			System.out.print(e + " ");
//		}
//		System.out.println();

//		System.out.println("\n" + arr.length);
//		int temp = obj.getNumOfBranches_K_Height(2);
//		System.out.println(temp);

//		scan.close();

	}

}
