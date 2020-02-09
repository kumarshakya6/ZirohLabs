/**
 * 
 */
package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vicky
 *
 */
public class BinaryTree {

	Node root;

	/**
	 * getInOrder() method traverses the Binary Tree in InOrder and returns List of
	 * elements of the Binary Tree
	 */

	public List<Integer> getInOrder() {

		// Creating ArrayList object type Integer
		List<Integer> arr = new ArrayList<>();

		// creating currentNode and assigning root to currentNode
		Node currentNode = root;
		// checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node> s = new Stack<>();
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

	/*
	 * travelPreOrder method prints all the tree elements preorder visit
	 */
	public List<Integer> getPreOrder() {
		// Creating ArrayList object type Integer
		List<Integer> arr = new ArrayList<>();

		// creating currentNode and assigning root to currentNode
		Node currentNode = root;
		// checking currentNode is null return empty list
		if (currentNode == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node> s = new Stack<>();
			s.push(currentNode);

			// running a loop until whole tree is not visited
			while (!s.isEmpty()) {
				Node temp = s.pop();
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
	public List<Integer> getPostOrder() {
		// Creating ArrayList object type Integer
		List<Integer> arr = new ArrayList<>();

		// creating currentNode and assigning root to currentNode

		// checking currentNode is null return empty list
		if (root == null) {
			return arr;
		}
		try {
			// creating s Stack object type of Node
			Stack<Node> s = new Stack<>();
			s.push(root);
			Node prev = null;

			// running a loop until whole tree is not visited
			while (!s.isEmpty()) {
				Node curr = s.getPeek();

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
		return countBranches(root);
	}

	/*
	 * countBranchesPrivate method takes input root of binary search tree , count
	 * the number of branches in it and return count of branches .
	 */
	private int countBranches(Node root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		return (countBranches(root.left) + countBranches(root.right));
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
