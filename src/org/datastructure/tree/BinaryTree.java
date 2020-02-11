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
	 * getLargestSumBranch() method find maximum sum of branch and return List of
	 * whole branch keys. and if tree do not has any key. It throws
	 * TreeIsEmptyException.
	 */

	public List<Integer> getLargestSumBranch() throws TreeIsEmptyException {

		if (root != null) {
			// getLargestSumBranch() method returns a Branch type object
			Branch outputPrintBranch = getLargestSumBranch(root);
			// returns the List of elements of Largest sum Branch
			return outputPrintBranch.elements;
		}

		// if tree do not has any node than throw TreeIsEmptyException
		throw new TreeIsEmptyException("Tree is empty");
	}

	// getLargestSumBranch() finds largest sum of branch and return Branch Object
	// that has
	// largest sum branch all elements and sum of that branch.
	private Branch getLargestSumBranch(Node root) {
		// creates a branch class object with root node data ;
		Branch branchOutput = new Branch(root.data, root.data);

		// if tree has only root node returns
		if (root.left == null && root.right == null) {
			return branchOutput;
		}

		// creates Left subtree and Right subtree branch objects
		Branch branchOfLeft, branchOfRight;

		// if right node null, calculate only left subtree and return it
		if (root.right == null) {

			branchOfLeft = getLargestSumBranch(root.left);
			branchOfLeft.sum += root.data;
			branchOfLeft.elements.add(0, root.data);
			return branchOfLeft;

		}
		// if left node null, calculate only right subtree and return it

		else if (root.left == null) {
			branchOfRight = getLargestSumBranch(root.right);
			branchOfRight.sum += root.data;
			branchOfRight.elements.add(0, root.data);
			return branchOutput;
		}
		// calculates left subtree and hold returns branch object by branchOfLeft
		branchOfLeft = getLargestSumBranch(root.left);
		branchOfLeft.sum += root.data;
		branchOfLeft.elements.add(0, root.data);

		// calculates right subtree and hold returns branch object by branchOfRight
		branchOfRight = getLargestSumBranch(root.right);
		branchOfRight.sum += root.data;
		branchOfRight.elements.add(0, root.data);

		// calls maxSumBranch() method gives two parameters Left and Right subtree
		// and return max Sum Branch object.
		return maxSumBranch(branchOfLeft, branchOfRight);
	}

	// TODO:
	private Branch maxSumBranch(Branch branch1, Branch branch2) {
		if (branch1.sum > branch2.sum) {
			return branch1;
		}
		return branch2;
	}

	/**
	 * Largest sum of a branch.
	 */

	public int getLargestSumOfBranch() throws TreeIsEmptyException {

		if (root != null)
			return getLargestSumOfBranch(root);

		throw new TreeIsEmptyException("Tree is empty");
	}

	private int getLargestSumOfBranch(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;

		return root.data + Math.max(getLargestSumOfBranch(root.left), getLargestSumOfBranch(root.right));
	}

	/**
	 * Smallest sum of a branch.
	 */
	public int getSmallestSumOfBranch() throws TreeIsEmptyException {
		if (root != null)
			return getSmallestSumOfBranch(root);

		throw new TreeIsEmptyException("Tree is Empty");
	}

	private int getSmallestSumOfBranch(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}

		return root.data + Math.min(getSmallestSumOfBranch(root.left), getSmallestSumOfBranch(root.right));
	}

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

	/**
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

	public int getHeight() {
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
