/**
 * 
 */
package org.datastructure.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakya
 *
 */
public class BinaryTree<T extends Comparable<T>> {

	Node<T> root;

	/**
	 * getInOrder() method traverses the Binary Tree in InOrder and returns List of
	 * elements of the Binary Tree
	 */

	public List<T> getInOrder() {

		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// creating currentNode and assigning root to currentNode
		Node<T> currentNode = root;
		// checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			// creating done variable type of boolean and assign false
			boolean done = false;

			// running a loop until whole tree is not visited
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
	 * travelPreOrder method prints all the tree elements preorder visit
	 */
	public List<T> getPreOrder() {
		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// creating currentNode and assigning root to currentNode
		Node<T> currentNode = root;
		// checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			s.push(currentNode);

			// running a loop until whole tree is not visited
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
	 * This is post order traversal method . It calls private travelPostOrder method
	 */
	public List<T> getPostOrder() {
		// Creating ArrayList object type Integer
		List<T> arr = new ArrayList<T>();

		// creating currentNode and assigning root to currentNode

		// checking currentNode is null return empty list
		if (root == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node<T>> s = new Stack<Node<T>>();
			s.push(root);
			Node<T> prev = null;

			// running a loop until whole tree is not visited
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
