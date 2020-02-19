package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * This is BinaryRadixTree. it works only for Search(0 and 1) strings. It has
 * tree methods insert, Search and getSorted. insert: it takes a string
 * parameter and adds string into the tree. if the string already exist, it do
 * not add it leave as it is. Search: it takes string parameter and checks it,
 * if it exists return true else false. getSorted: it just returns
 * List(ArrayList<String>) of Keys
 * 
 * 
 */
public class BinaryRadixTree {
	private RadixNode root = new RadixNode();

	private char oneChar = '1';
	private char zeroChar = '0';

	/**
	 * it takes a string parameter and adds string into the tree. if the string
	 * already exist, it do not add it leave as it is.
	 */

	/**
	 * 
	 * @param str
	 */
	public void insert(String str) {
		String data = "";
		RadixNode current = root;

		for (int index = 0; index < str.length(); index++) {
			data = data + str.charAt(index);
			if (str.charAt(index) == oneChar) {

				if (current.right == null) {

					current.right = new RadixNode();

				}
				current = current.right;
			} else {
				if (current.left == null) {
					current.left = new RadixNode();
				}
				current = current.left;
			}

		}
		current.flag = true;

	}

	/**
	 * it takes string parameter and checks it, if it exists return true else false.
	 **/

	public boolean search(String str) {

		// String empty return root flag
		if (str == "") {
			return root.flag;
		}

		// root assigns current variable
		RadixNode current = root;
		// run loop until , finds null or 0 to less than string length
		for (int index = 0; index < str.length(); index++) {
			// current is null return false;
			if (current == null) {
				return false;
			}
			// move right subtree
			if (str.charAt(index) == oneChar) {

				current = current.right;
			}
			// moves to left subtree
			else {

				current = current.left;
			}
		}

		// current flag
		return current.flag;
	}

	/**
	 * it traversals the whole tree and returns List(ArrayList<String>) of Keys
	 */
	public List<String> getSorted() {
		String data = "";
		return getSorted(root, data);

	}

	private List<String> getSorted(RadixNode root, String data) {
		List<String> arr = new ArrayList<>();
		if (root == null) {
			return arr;
		}

		// existed keys add into the ListArray
		if (root.flag) {
			arr.add(data);
		}
		// traversals left subtree
		arr.addAll(getSorted(root.left, data + 0));

		// traversals right subtree
		arr.addAll(getSorted(root.right, data + 1));

		return arr;

	}

}
