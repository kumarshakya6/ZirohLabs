/**
 * 
 */
package org.datastructure.tree;

/**
 * @author vicky
 *
 */
public class BinaryTree {

	Node root;

	/**
	 * getInOrder() method traverses the Binary Tree in InOrder and returns array of
	 * elements of the Binary Tree
	 */

	public int[] getInOrder() {

		String str[] = getInOrderPrivate(root).split(" ");
		int arr[] = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		return arr;

	}

	private String getInOrderPrivate(Node root) {
		if (root == null) {
			return "";
		}

		return getInOrderPrivate(root.left) + "" + root.data + " " + getInOrderPrivate(root.right);

	}

	/*
	 * travelPreOrder method prints all the tree elements preorder visit
	 */
	public int[] getPreOrder() {
		String str[] = getPreOrderPrivate(root).split(" ");
		int arr[] = new int[str.length];
//		for (int i = 0; i < str.length; i++) {
//			arr[i] = Integer.parseInt(str[i]);
//		}
		return arr;
	}

	/*
	 * travelPreOrder method takes input root of binary search tree and prints all
	 * the tree elements in preorder visit
	 */
	private String getPreOrderPrivate(Node node) {
		if (root == null) {
			return "";
		}
		return root.data + " " + getPreOrderPrivate(root.left) + "" + getPreOrderPrivate(root.right);

	}

	/**
	 * This is post order traversal method . It calls private travelPostOrder method
	 */
	public void getPostOrder() {
		String str = getPostOrderPrivate(root);
		System.out.println(str);
	}

	/*
	 * This is post order traversal.It has one parameter node. It prints all the
	 * data of binary search tree
	 */
	private String getPostOrderPrivate(Node root) {
		if (root == null) {
			return "";
		}

		return getPostOrderPrivate(root.left) + "" + getPostOrderPrivate(root.right) + " " + root.data;

	}

	/*
	 * countNodes method counts the number of node in the binary search tree and
	 * return the count of nodes
	 */
	public int countNodes() {
		return countNodesPrivate(root);
	}

	/*
	 * countNodesPrivate method takes input root of binary search tree and counts
	 * the number of node in the binary search tree and return the count of nodes
	 */
	private int countNodesPrivate(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		return countNodesPrivate(root.left) + countNodesPrivate(root.right);
	}
	/*
	 * countLeafNode counts the number of leaf node in the binary search tree and
	 * return it
	 */

	public int countLeafNodes() {
		return countLeafNodesPrivate(root);
	}

	/*
	 * countLeafNodePrivate method takes input root of binary search tree , count
	 * the number of branches in it and return count of branches .
	 */
	private int countLeafNodesPrivate(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		return (countLeafNodesPrivate(root.left) + countLeafNodesPrivate(root.right));
	}

	/*
	 * countBranches count the number of branches in the binary search tree and
	 * return it
	 */
	public int countBranches() {
		return countBranchesPrivate(root);
	}

	/*
	 * countBranchesPrivate method takes input root of binary search tree , count
	 * the number of branches in it and return count of branches .
	 */
	private int countBranchesPrivate(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		return (countBranchesPrivate(root.left) + countBranchesPrivate(root.right));
	}

	public int countInternalNodes() {
		return countInternalNodesPrivate(root);
	}

	private int countInternalNodesPrivate(Node root) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}

		return (countNodesPrivate(root) - countLeafNodesPrivate(root) - 1);
	}

	/*
	 * countHeight method counts the height of the binary search tree and return it
	 */

	public int countHeight() {
		return countHeightPrivate(root);
	}

	/*
	 * countHeight method takes input root of the binary search tree and counts the
	 * height of the binary search tree and return it
	 */
	private int countHeightPrivate(Node root) {

		if (root == null) {
			return -1;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return 1 + Math.max(countHeightPrivate(root.right), countHeightPrivate(root.left));
	}

	/**
	 * getNumOfBranches_K_SharedEdges method takes the input of shared edges number
	 * and count the shared edges branches and return it
	 */
	public int getNumOfBranches_K_SharedEdges(int k) {
		return getNumOfBranches_K_SharedEdgesPrivate(root, k);
	}

	private int getNumOfBranches_K_SharedEdgesPrivate(Node root, int k) {
		if (root == null) {
			return 0;
		}
		if (root.right == null && root.left == null && k == -1) {
			return 1;
		}
		if (k < -1) {
			return 0;
		}

		return getNumOfBranches_K_SharedEdgesPrivate(root.left, k - 1)
				+ getNumOfBranches_K_SharedEdgesPrivate(root.right, k - 1);
	}

	/**
	 * getNumOfBranches_K_Height method takes height of branches parameter integer
	 * type and count the Number of branches with height as a given input and return
	 * number of branches integer type in the tree
	 * 
	 */

	public int getNumOfBranches_K_Height(int k) {
		return getNumOfBranches_K_HeightPrivate(root, k);
	}

	private int getNumOfBranches_K_HeightPrivate(Node root, int k) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null && k == 0) {
			return 1;
		}
		if (k < 0) {
			return 0;
		}

		return getNumOfBranches_K_HeightPrivate(root.left, k - 1) + getNumOfBranches_K_HeightPrivate(root.right, k - 1);

	}

	/**
	 * getNumOfBranches_Less_K_Height method takes height of branches parameter
	 * integer type and count the Number of branches with height as a given input
	 * and return number of branches integer type in the tree
	 * 
	 */

	public int getNumOfBranches_Less_K_Height(int k) {
		return getNumOfBranches_Less_K_HeightPrivate(root, k);
	}

	private int getNumOfBranches_Less_K_HeightPrivate(Node root, int k) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null && k >= 0) {
			return 1;
		}
		if (k < 0) {
			return 0;
		}

		return getNumOfBranches_Less_K_HeightPrivate(root.left, k - 1)
				+ getNumOfBranches_Less_K_HeightPrivate(root.right, k - 1);

	}

	/**
	 * getNumOfBranches_Greater_K_Height method takes height of branches parameter
	 * integer type and count the Number of branches greater height as a given input
	 * and return number of branches integer type in the tree
	 * 
	 */

	public int getNumOfBranches_Greater_K_Height(int k) {
		return getNumOfBranches_Greater_K_HeightPrivate(root, k);
	}

	private int getNumOfBranches_Greater_K_HeightPrivate(Node root, int k) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null && k < 0) {
			return 1;
		}

		return getNumOfBranches_Greater_K_HeightPrivate(root.left, k - 1)
				+ getNumOfBranches_Greater_K_HeightPrivate(root.right, k - 1);

	}

	/**************************************************
	 * this code is only of checks
	 *****************/
//	private Node root;
//	private int numOfNodes = 0;
//	int arr[] = new int[numOfNodes];
//	private int index = 0;
//
//	public int[] getInOrder() {
//		index = 0;
//		getInOrderPrivate(root);
//		return arr;
//	}
//
//	private void getInOrderPrivate(Node current) {
//		if (current == null || (current.left == null && current.right == null)) {
//			return;
//		}
//		getInOrderPrivate(current.left);
//		arr[index++] = current.data;
//		getInOrderPrivate(current.right);
//	}
//
//	public int[] getPreOrder() {
//		index = 0;
//		getPreOrderPrivate(root);
//		return arr;
//	}
//
//	private void getPreOrderPrivate(Node current) {
//		if (current == null || (current.left == null && current.right == null)) {
//			return;
//		}
//		getPreOrderPrivate(current.left);
//		arr[index++] = current.data;
//		getPreOrderPrivate(current.right);
//	}
//
//	public int[] getPostOrder() {
//		index = 0;
//		getPostOrderPrivate(root);
//		return arr;
//	}
//
//	private void getPostOrderPrivate(Node current) {
//		if (current == null || (current.left == null && current.right == null)) {
//			return;
//		}
//		getPostOrderPrivate(current.left);
//		arr[index++] = current.data;
//		getPostOrderPrivate(current.right);
//	}
//
//	public int getNumOfNodes() {
//		return getNumOfNodesPrivate();
//	}
//
//	private int getNumOfNodesPrivate() {
//		return numOfNodes;
//	}

}
