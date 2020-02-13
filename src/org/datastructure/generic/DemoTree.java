package org.datastructure.generic;

import java.util.List;

public class DemoTree {

	public static void main(String[] args) throws TreeIsEmptyException {

		BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		intTree.insert(10);
		System.out.println(intTree.search(10));
		intTree.insert(20);
		intTree.insert(5);
		intTree.insert(50);
		List<Integer> arr = intTree.getInOrder();
		System.out.println(arr.size());
		for (Integer e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
		BinarySearchTree<String> strTree = new BinarySearchTree<String>();
		strTree.insert("aa");
		strTree.insert("bb");
		strTree.insert("ee");
		strTree.insert("zirohlabs");
		strTree.insert("bangalore");
		System.out.println(strTree.search("zirohlabs "));

		List<String> arr1 = strTree.getInOrder();
		System.out.println(arr1.size());

		for (String s : arr1) {
			System.out.print(s + " ");
		}

	}

}
