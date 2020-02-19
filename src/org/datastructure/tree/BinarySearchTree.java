/**
 * 
 */
package org.datastructure.tree;

/**
 * @author vicky
 *
 *         This class inherit the BinaryTree class and Override INSERT, DELETE
 *         method and also added new GET MIN VALUE, GET MAX VALUE,
 */

public class BinarySearchTree extends BinaryTree {

	/**
	 * This method has one parameter key. It adds new value in the binary Search
	 * Tree
	 * 
	 * @param key
	 */

	public void insert(int data) {
		// if (!Search(key)) {
		root = insert(root, data);
		// }

	}

	/*
	 * insertRecursion method It has two parameters one is root Node type and
	 * another is key(integer type) and . It adds new node in Search Search Tree
	 * and It returns root Node of Search Search Tree
	 */

	private Node insert(Node root, int data) {

		// if root is null than create a new node and returns it
		if (root == null) {
			root = new Node(data);
			return root;
		}

		// if given key is less than root key call recursive method for left subtree
		if (root.data > data) {
			Node left = insert(root.left, data);
			left.parent = root;
			root.left = left;
			// root.left = insert(root.left, key);

		}
		// if given key is greater than root key call recursive method for right
		// substree
		else if (root.data < data) {
			Node right = insert(root.right, data);
			right.parent = root;
			root.right = right;

			// root.right = insert(root.right, key);
		}

		// return root node finally
		return root;

	}

	/**
	 * 
	 * @param key
	 * @return
	 */

	/*
	 * This is Search method is have one argument key integer type and Search that
	 * element. If it finds the element return true else return false
	 */
	public boolean search(int data) {
		return search(root, data);

	}

	/*
	 * searchPrivate method is have two argument. one is root(Node type) and another
	 * is key(integer type) and Search that element. If it finds the element return
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
	 * This is method is takes root and key of the node and return the height of the
	 * of given node
	 */

	private int getHeightGivenNode(Node root, int data) {
		if (root == null)
			return -1;

		if (root.data == data) {
			return 0;
		}

		if (root.data < data) {
			return 1 + getHeightGivenNode(root.right, data);
		} else {
			return 1 + getHeightGivenNode(root.left, data);
		}
	}

	public int getLeftMostSibling(int data) {
		int height = getHeightGivenNode(root, data);
		return getLeftMostSibling(root, data, height);

	}

	private int getLeftMostSibling(Node root, int data, int height) {
		if (height == 0 && data != root.data) {

			return root.data;
		} else if (height > -1) {

			if (root.right != null) {
				return getLeftMostSibling(root.right, data, height - 1);
			}
			if (root.left != null) {
				return getLeftMostSibling(root.left, data, height - 1);
			}
		}

		return -1;
	}

	/**
	 * This method is get the given key Right most sibling if exists else return
	 * -1;
	 */
	public int getRightMostSibling(int data) {
		int height = getHeight();
		return getRightMostSibling(root, data, height);

	}

	private int getRightMostSibling(Node root, int data, int height) {

		if (height == 0 && data != root.data) {

			return root.data;
		} else if (height > -1) {
			if (root.right != null) {
				return getRightMostSibling(root.right, data, height - 1);
			}
			if (root.left != null) {
				return getRightMostSibling(root.left, data, height - 1);
			}
		}

		return -1;

	}

	/*
	 * findMinValueNode method Search the minimum value of binary Search tree and
	 * return it and if tree is null than It return -1
	 */

	public int getMinValue() throws EmptyTreeException {
		if (root != null)
			return getMinValue(root);
		throw new EmptyTreeException("Tree is null");
	}

	/*
	 * findMinValueNodePrivate method takes input root type of Node and Search the
	 * minimum value node of binary Search tree and return it and if the tree is
	 * null it returns null.
	 */

	protected int getMinValue(Node root) {

		if (root.left == null) {
			return root.data;
		}

		return getMinValue(root.left);
	}

	/*
	 * findMaxValueNode method Search the Maximum value of binary Search tree and
	 * return it and if tree is null than It return -1
	 */

	public int getMaxValue() throws EmptyTreeException {
		return getMaxValue(root);
	}

	/*
	 * getMaxValuePrivate method takes input root type of Node and Search the
	 * Maximum value node of binary Search tree and return it
	 */
	private int getMaxValue(Node root) throws EmptyTreeException {
		if (root == null) {
			throw new EmptyTreeException("Tree is null");
		}
		if (root.right == null) {
			return root.data;
		}

		return getMaxValue(root.right);
	}

	public void delete(int data) throws EmptyTreeException {
		root = delete(root, data);
	}

	private Node delete(Node root, int data) throws EmptyTreeException {

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

}
