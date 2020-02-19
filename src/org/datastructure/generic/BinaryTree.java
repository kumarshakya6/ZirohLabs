/*//TODO: add comments in this class 
 * 
 */
package org.datastructure.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakya
 * 
 *         This class represents binary tree class
 */
public class BinaryTree<T extends Comparable<T>> {

	protected Node<T> root;

	/**
	 * This method traverses the Search Tree in InOrder and returns List of elements
	 * 
	 */

	public List<T> getInOrder() {

		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// Creating currentNode and assigning root to currentNode
		Node<T> currentNode = root;
		// Checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// Creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			// Creating done variable type of boolean and assign false
			boolean done = false;

			// Running a loop until whole tree is not visited
			while (!done) {

				if (currentNode != null) {
					s.push(currentNode);
					currentNode = currentNode.left;
				} else {
					if (s.isEmpty()) {
						done = true;
					} else {
						currentNode = s.pop();
						arr.add(currentNode.data);
						currentNode = currentNode.right;
					}
				}
			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return arr;

	}

	/**
	 * This method traversals in PreOrder whole tree and returns List of elements
	 */
	public List<T> getPreOrder() {
		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// Creating currentNode and assigning root to currentNode
		Node<T> currentNode = root;
		// Checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// Creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			s.push(currentNode);

			// Running a loop until whole tree is not visited
			while (!s.isEmpty()) {
				Node<T> temp = s.pop();
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

	/**
	 * This method traverses in Post Order whole tree . It returns List of elements
	 */

	public List<T> getPostOrder() {
		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// Creating currentNode and assigning root to currentNode

		// Checking currentNode is null return empty list
		if (root == null) {
			return arr;
		}
		try {
			// Creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			s.push(root);
			Node<T> prev = null;

			// Running a loop until whole tree is not visited
			while (!s.isEmpty()) {
				Node<T> curr = s.getPeek();

				if (prev == null || prev.left == curr || prev.right == curr) {
					if (curr.left != null) {
						s.push(curr.left);
					} else if (curr.right != null) {
						s.push(curr.right);
					}
				} else if (curr.left == prev) {
					if (curr.right != null) {
						s.push(curr.right);
					}
				} else {
					arr.add(curr.data);
					s.pop();
				}
				prev = curr;

			}

		} catch (Exception e) {
			System.out.print(e);
		}

		return arr;

	}

}
