/**
 * 
 */
package org.datastructure.tree;

/**
 * @author vicky
 *
 *         This is BinarySearchTree
 */

public class BinarySearchTree extends BinaryTree {

	/**
	 * This insert method It has one parameter data(integer type). It adds new node
	 * in Binary Search Tree
	 */

	public void insert(int data) {
		if (!search(data)) {
			root = insert(root, data);
		}

	}

	/*
	 * insertRecursion method It has two parameters one is root Node type and
	 * another is data(integer type) and . It adds new node in Binary Search Tree
	 * and It returns root Node of Binary Search Tree
	 */

	private Node insert(Node root, int data) {

		// if root is null than create a new node and returns it
		if (root == null) {
			root = new Node(data);
			return root;
		}

		// if given data is less than root data call recursive method for left subtree
		if (root.data > data) {
			root.left = insert(root.left, data);

		}
		// if given data is greater than root data call recursive method for right
		// substree
		else if (root.data < data) {
			root.right = insert(root.right, data);
		}

		// return root node finally
		return root;

	}

	/*
	 * This is search method is have one argument data integer type and search that
	 * element. If it finds the element return true else return false
	 */
	public boolean search(int data) {
		return search(root, data);

	}

	/*
	 * searchPrivate method is have two argument. one is root(Node type) and another
	 * is data(integer type) and search that element. If it finds the element return
	 * Node else return null
	 */
	private boolean search(Node root, int data) {
		if (root == null)
			return false;

		if (root.data == data) {
			return true;
		}

		if (root.data < data) {
			return search(root.right, data);
		} else {
			return search(root.left, data);
		}
	}

	/*
	 * findMinValueNode method search the minimum value of binary search tree and
	 * return it and if tree is null than It return -1
	 */

	public int getMinValue() throws TreeIsEmptyException {
		return getMinValue(root);
	}

	/*
	 * findMinValueNodePrivate method takes input root type of Node and search the
	 * minimum value node of binary search tree and return it and if the tree is
	 * null it returns null.
	 */

	private int getMinValue(Node root) throws TreeIsEmptyException {
		if (root == null) {
			throw new TreeIsEmptyException("Tree is null");
		}
		if (root.left == null) {
			return root.data;
		}

		return getMinValue(root.left);
	}

	/*
	 * findMaxValueNode method search the Maximum value of binary search tree and
	 * return it and if tree is null than It return -1
	 */

	public int getMaxValue() throws TreeIsEmptyException {
		return getMaxValue(root);
	}

	/*
	 * getMaxValuePrivate method takes input root type of Node and search the
	 * Maximum value node of binary search tree and return it
	 */
	private int getMaxValue(Node root) throws TreeIsEmptyException {
		if (root == null) {
			throw new TreeIsEmptyException("Tree is null");
		}
		if (root.right == null) {
			return root.data;
		}

		return getMaxValue(root.right);
	}

	public void delete(int data) throws TreeIsEmptyException {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) throws TreeIsEmptyException {

		if (root == null) {
			return root;
		}

		if (root.data > data) {
			root.left = delete(root.left, data);
		} else if (root.data < data) {
			root.right = delete(root.right, data);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {

				root.data = getMinValue(root.right);

				root.right = delete(root.right, root.data);

			}

		}
		return root;

	}
	/*
	 * **************************************************************
	 * 
	 * This code for insert duplicate
	 */
//	  private void insertPrivate(int data) {
//		Node parent = null;
//		Node current = root;
//		Node newNode = new Node(data);
//		if (root == null) {
//			root = newNode;
//			return;
//		}
//
//		while (current != null) {
//			parent = current;
//			if (current.data > data) {
//
//				current = current.left;
//			} else {
//				current = current.right;
//			}
//		}
//
//		if (parent.data > data) {
//			parent.left = newNode;
//
//		} else {
//			parent.right = newNode;
//		}
//
//	}

	/***************************************************************/

}
