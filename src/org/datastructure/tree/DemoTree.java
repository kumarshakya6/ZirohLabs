package org.datastructure.tree;

import java.util.Scanner;

public class DemoTree {

	public static void main(String[] args) throws EmptyTreeException {

		Scanner scan = new Scanner(System.in);

		int a = 5;
		int b = 8;
		try {
			int out = a / b;

			System.out.println(out);

		} catch (ArithmeticException e) {
			System.out.println(e);
		}

		Integer g = 10;
		Node n = new Node(10);
		System.out.println(g.getClass() + ": this is g");
		System.out.println(n.toString());

		// System.out.println( + ": this is g");

		System.out.println("This is working without exception");

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

//		BinarySearchTree obj = new BinarySearchTree();
//
//		obj.insert(12);
//		obj.insert(5);
//		obj.insert(20);
//		obj.insert(17);
//		obj.insert(50);
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

		scan.close();

	}

}
