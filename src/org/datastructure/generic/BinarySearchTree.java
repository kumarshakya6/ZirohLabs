
//TODO: add comments in this class 
package org.datastructure.generic;

/**
 * @author vicky
 *
 *         This is BinarySearchTree
 */

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	/**
	 * This method takes input T type and add element in Search Search Tree .
	 */

	public void insert(T data) {

		if (!search(data)) {

			root = insert(root, data);
		}

	}

	/*
	 * insertRecursion method It has two parameters one is root Node type and
	 * another is key(integer type) and . It adds new node in Search Search Tree
	 * and It returns root Node of Search Search Tree
	 */

	private Node<T> insert(Node<T> root, T data) {

		// If root is null than create a new node and returns it
		if (root == null) {
			root = new Node<T>(data);
			return root;
		}

		// If given key is less than root key call recursive method for left subtree
		if (root.data.compareTo(data) > 0) {
			root.left = insert(root.left, data);

		}
		// If given key is greater than root key call recursive method for right
		// Subtree
		else if (root.data.compareTo(data) < 0) {
			root.right = insert(root.right, data);
		}

		// Return root node finally
		return root;

	}

	/**
	 * This method takes one input T type and check it exist if yes return true else
	 * false.
	 */
	public boolean search(T data) {

		return search(root, data);

	}

	/*
	 * searchPrivate method is have two argument. one is root(Node type) and another
	 * is key(integer type) and Search that element. If it finds the element return
	 * Node else return null
	 */
	private boolean search(Node<T> root, T data) {
		if (root == null)
			return false;

		if (root.data.compareTo(data) == 0) {
			return true;
		}

		if (root.data.compareTo(data) > 0) {
			return search(root.left, data);
		} else {
			return search(root.right, data);
		}
	}

	/**
	 * This method takes input T type and delete input element if exist and throws
	 * EmptyTreeException.
	 */

	public void delete(T data) throws EmptyTreeException {

		root = delete(root, data);
	}

	private Node<T> delete(Node<T> root, T data) throws EmptyTreeException {

		if (root == null) {
			return root;
		}

		if (root.data.compareTo(data) > 0) {
			root.left = delete(root.left, data);
		} else if (root.data.compareTo(data) < 0) {
			root.right = delete(root.right, data);
		} else {

			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {

				root = getMinValue(root.right);

				root.right = delete(root.right, root.data);

			}

		}
		return root;

	}

	private Node<T> getMinValue(Node<T> root) throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException("Tree is null");
		}
		if (root.left == null) {
			return root;
		}

		return getMinValue(root.left);
	}

	/*
	 * This is method is takes root and key of the node and return the height of the
	 * of given node
	 */

//	private int getHeightGivenNode(Node root, int key) {
//		if (root == null)
//			return -1;
//
//		if (root.data == key) {
//			return 0;
//		}
//
//		if (root.data < key) {
//			return 1 + getHeightGivenNode(root.right, key);
//		} else {
//			return 1 + getHeightGivenNode(root.left, key);
//		}
//	}
//
//	public int getLeftMostSibling(int key) {
//		int height = getHeightGivenNode(root, key);
//		return getLeftMostSibling(root, key, height);
//
//	}
//
//	private int getLeftMostSibling(Node root, int key, int height) {
//		if (height == 0 && key != root.data) {
//
//			return root.data;
//		} else if (height > -1) {
//
//			if (root.right != null) {
//				return getLeftMostSibling(root.right, key, height - 1);
//			}
//			if (root.left != null) {
//				return getLeftMostSibling(root.left, key, height - 1);
//			}
//		}
//
//		return -1;
//	}
//
//	/**
//	 * This method is get the given key Right most sibling if exists else return
//	 * -1;
//	 */
//	public int getRightMostSibling(int key) {
//		int height = getHeight();
//		return getRightMostSibling(root, key, height);
//
//	}
//
//	private int getRightMostSibling(Node root, int key, int height) {
//
//		if (height == 0 && key != root.data) {
//
//			return root.data;
//		} else if (height > -1) {
//			if (root.right != null) {
//				return getRightMostSibling(root.right, key, height - 1);
//			}
//			if (root.left != null) {
//				return getRightMostSibling(root.left, key, height - 1);
//			}
//		}
//
//		return -1;
//
//	}
//
//	/*
//	 * findMinValueNode method Search the minimum value of binary Search tree and
//	 * return it and if tree is null than It return -1
//	 */
//
//	public int getMinValue() throws TreeIsEmptyException {
//		return getMinValue(root);
//	}
//
//	/*
//	 * findMinValueNodePrivate method takes input root type of Node and Search the
//	 * minimum value node of binary Search tree and return it and if the tree is
//	 * null it returns null.
//	 */
//

//
//	/*
//	 * findMaxValueNode method Search the Maximum value of binary Search tree and
//	 * return it and if tree is null than It return -1
//	 */
//
//	public Integer getMaxValue() throws TreeIsEmptyException {
//		return getMaxValue(root);
//	}
//
//	/*
//	 * getMaxValuePrivate method takes input root type of Node and Search the
//	 * Maximum value node of binary Search tree and return it
//	 */
//	private Integer getMaxValue(Node root) throws TreeIsEmptyException {
//		if (root == null) {
//			throw new TreeIsEmptyException("Tree is null");
//		}
//		if (root.right == null) {
//			return root.data;
//		}
//
//		return getMaxValue(root.right);
//	}

	/*
	 * **************************************************************
	 * 
	 * This code for insert duplicate
	 */
//	  private void insertPrivate(int key) {
//		Node parent = null;
//		Node current = root;
//		Node newNode = new Node(key);
//		if (root == null) {
//			root = newNode;
//			return;
//		}
//
//		while (current != null) {
//			parent = current;
//			if (current.data > key) {
//
//				current = current.left;
//			} else {
//				current = current.right;
//			}
//		}
//
//		if (parent.data > key) {
//			parent.left = newNode;
//
//		} else {
//			parent.right = newNode;
//		}
//
//	}

	/***************************************************************/

}
