package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryRadixTree {
	RadixNode root = new RadixNode("");
	private char oneChar = '1';
	/// private char zeroChar = '0';

	/**
	 * This insert a binary string into the BinaryRadixTree. It takes a string type
	 * parameter for binary string
	 */
	public void insert(String str) {
		String data = "";
		RadixNode current = root;

		for (int index = 0; index < str.length(); index++) {
			data = data + str.charAt(index);
			if (str.charAt(index) == oneChar) {

				if (current.right == null) {

					current.right = new RadixNode(data);

				}
				current = current.right;
			} else {
				if (current.left == null) {
					current.left = new RadixNode(data);
				}
				current = current.left;
			}

		}
		current.flag = true;

	}

	public boolean search(String str) {
		if (str == "") {
			return root.flag;
		}
		RadixNode current = root;
		for (int index = 0; index < str.length(); index++) {
			if (current == null) {
				return false;
			}
			if (str.charAt(index) == oneChar) {
				current = current.right;
			} else {
				current = current.left;
			}
		}

		if (str.equals(current.data) && current.flag) {
			return true;
		}
		return false;
	}

	public List<String> getPreOrder() {
		// Creating ArrayList object type Integer
		List<String> arr = new ArrayList<>();

		// creating currentNode and assigning root to currentNode
		RadixNode current = root;
		// checking currentNode is null return empty list
		if (current == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<RadixNode> s = new Stack<>();
			s.push(current);

			// running a loop until whole tree is not visited
			while (!s.isEmpty()) {
				RadixNode temp = s.pop();
				if (temp.flag)
					arr.add(temp.data);
				if (temp.right != null) {
					s.push(temp.right);
				}
				if (temp.left != null) {
					s.push(temp.left);
				}

			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return arr;
	}

}
