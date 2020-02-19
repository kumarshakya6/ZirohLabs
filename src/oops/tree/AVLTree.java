package oops.tree;

public class AVLTree extends BST {

	@Override
	public void insert(int data) {
		if (root == null) {
			root = new AVLRootNode(data);
			return;
		}
		root = insert(root, data);
	}

	private Node insert(Node current, int data) {

		// BASE CASE Node is null
		if (current == null) {
			return new AVLLeafNode(data);
		}
		// BASE CASE Node is exist
		if (current.data == data) {
			return current;
		}
		// BASE CASE Node is Leaf
		if (current instanceof AVLLeafNode) {
			current = changeNodeToInternalNode(current);

			if (current.data > data) {
				((AVLInternalNode) current).left = new AVLLeafNode(data);
			} else {
				((AVLInternalNode) current).right = new AVLLeafNode(data);
			}
		}

		// Recursive CASE for Leaf subtree
		if (current.data > data) {
			if (current instanceof AVLRootNode) {
				((AVLRootNode) current).left = insert(((AVLRootNode) current).left, data);
			} else {
				((AVLInternalNode) current).left = insert(((AVLInternalNode) current).left, data);
			}

			// Recursive CASE for Right subtree
		} else if (current.data < data) {
			if (current instanceof AVLRootNode) {
				((AVLRootNode) current).right = insert(((AVLRootNode) current).right, data);
			} else {
				((AVLInternalNode) current).right = insert(((AVLInternalNode) current).right, data);
			}

		}

		// Calculate height of current node
		if (current instanceof AVLLeafNode) {
			// Leaf Node height
			((AVLLeafNode) current).height = 0;
		} else if (current instanceof AVLRootNode) {
			// Root Node height
			((AVLRootNode) current).height = calculateHeight(current);
		} else {
			// Internal Node height
			((AVLInternalNode) current).height = calculateHeight(current);
		}

		// Get Balance Factor
		int balanceFactor = getBalance(current);

		// Left
		if (balanceFactor > 1) {
			int rightBF;
			if (current instanceof AVLRootNode) {
				rightBF = getBalance(((AVLRootNode) current).left);
			} else {
				rightBF = getBalance(((AVLInternalNode) current).left);
			}

			// Left Left Rotation
			if (rightBF == 1) {
				current = leftRotate(current);

				// Left Right Rotation
			} else if (rightBF == -1) {
				current = leftRightRotate(current);
			}

			// Right
		} else if (balanceFactor < -1) {

			int leftBF;
			if (current instanceof AVLRootNode) {
				leftBF = getBalance(((AVLRootNode) current).right);
			} else {
				leftBF = getBalance(((AVLInternalNode) current).right);
			}

			// Left Left Rotation
			if (leftBF == 1) {
				current = rightLeftRotate(current);

				// Left Right Rotation
			} else if (leftBF == -1) {
				current = rightRotate(current);
			}

		}

		return current;
	}

//	public void delete(int data) {
//		
//	}
//	
////	private Node delete(Node current,int data) {
////		
////	}

	private int getHeight(Node node) {
		// Node is null
		if (node == null) {
			return -1;
		}

		// Node is Leaf node
		if (node instanceof AVLLeafNode) {
			return ((AVLLeafNode) node).height;
			// Node is Root node
		} else if (node instanceof AVLRootNode) {
			return ((AVLRootNode) node).height;

			// Node is Internal node
		} else {
			return ((AVLInternalNode) node).height;
		}
	}

	/*
	 * This calculates height of given node
	 */
	int calculateHeight(Node node) {
		int leftHeight;
		int rightHeight;

		// Node is Leaf node
		if (node instanceof AVLLeafNode) {
			return 0;

			// Node is Root node
		} else if (node instanceof AVLRootNode) {

			// Left subtree height
			leftHeight = getHeight(((AVLRootNode) node).left);
			// Right subtree height
			rightHeight = getHeight(((AVLRootNode) node).right);

			// Node is Internal node
		} else {

			// Left subtree height
			leftHeight = getHeight(((AVLInternalNode) node).left);
			// Right subtree height
			rightHeight = getHeight(((AVLInternalNode) node).right);

		}

		// Check max height of left and right and add 1 with it
		return 1 + Math.max(leftHeight, rightHeight);
	}

	/*
	 * This method takes a parameter as a input and calculate the balance factor of
	 * that node and return it
	 */
	// Calculate balance factor of given node
	int getBalance(Node node) {
		int leftHeight;
		int rightHeight;

		// Node is Leaf node
		if (node instanceof AVLLeafNode) {
			return 0;

			// Node is Root node
		} else if (node instanceof AVLRootNode) {

			// Left subtree height
			leftHeight = getHeight(((AVLRootNode) node).left);
			// Right subtree height
			rightHeight = getHeight(((AVLRootNode) node).right);

			// Node is Internal node
		} else {

			// Left subtree height
			leftHeight = getHeight(((AVLInternalNode) node).left);
			// Right subtree height
			rightHeight = getHeight(((AVLInternalNode) node).right);

		}

		return leftHeight - rightHeight;

	}

	public int getHeight() {
		return getHeight(root);
	}

	// Right Right Rotation
	Node rightRotate(Node A) {
		// Left of A
		Node T1;
		// Right of A
		Node B;
		// Left of B
		Node T2;
		// Right of B
		Node T3;

		// Assign left and right of Node
		if (A instanceof AVLRootNode) {

			T1 = ((AVLRootNode) A).left;
			B = ((AVLRootNode) A).right;
		} else {
			T1 = ((AVLInternalNode) A).left;
			B = ((AVLInternalNode) A).right;
		}

		// Assign left of right child of node and right of right child of node

		if (B instanceof AVLInternalNode) {

			T2 = ((AVLInternalNode) B).left;
			T3 = ((AVLInternalNode) B).right;

		} else {
			T3 = null;
			T2 = null;
		}

		// CASE First: A is Root and B is Internal
		if (A instanceof AVLRootNode && B instanceof AVLInternalNode) {
			B = changeNodeToRootNode(B);
			A = changeNodeToInternalNode(A);
			((AVLInternalNode) A).left = T1;
			((AVLInternalNode) A).right = T2;

			((AVLInternalNode) A).height = calculateHeight(((AVLInternalNode) A));

			((AVLRootNode) B).left = A;
			((AVLRootNode) B).right = T3;

			((AVLRootNode) B).height = calculateHeight(((AVLRootNode) B));

			return B;
		}
		// CASE Second: A and B both Internal

		if (A instanceof AVLInternalNode && B instanceof AVLInternalNode) {
			((AVLInternalNode) A).left = T1;
			((AVLInternalNode) A).right = T2;

			((AVLInternalNode) A).height = calculateHeight(((AVLInternalNode) A));
			((AVLInternalNode) B).left = A;
			((AVLInternalNode) B).right = T3;

			((AVLInternalNode) B).height = calculateHeight(((AVLInternalNode) B));

			return B;

		}

		// CASE Third: A is Internal and B is Leaf
		if (A instanceof AVLInternalNode && B instanceof AVLLeafNode) {
			B = changeNodeToInternalNode(B);
			A = changeNodeToLeafNode(A);
			// There is no need to change height of LeafNode
			((AVLInternalNode) B).left = A;
			((AVLInternalNode) B).right = T3;

			((AVLInternalNode) B).height = calculateHeight(((AVLInternalNode) B));

			return B;
		}

		return B;
	}

	// Right Left Rotation
	Node rightLeftRotate(Node node) {

		// Left Rotation
		// Node is Root
		if (node instanceof AVLRootNode) {
			((AVLRootNode) node).right = leftRotate(((AVLRootNode) node).right);

			// Node is Internal
		} else {
			((AVLInternalNode) node).right = leftRotate(((AVLInternalNode) node).right);
		}

		// Right Rotation
		return rightRotate(node);
	}

	// Left Right Rotation
	Node leftRightRotate(Node node) {
		// Right Rotation
		// Node is Root
		if (node instanceof AVLRootNode) {
			((AVLRootNode) node).left = rightRotate(((AVLRootNode) node).left);

			// Node is Internal
		} else {
			((AVLInternalNode) node).left = rightRotate(((AVLInternalNode) node).left);
		}

		// Left Rotation
		return leftRotate(node);

	}

	// Left Left Rotation

	Node leftRotate(Node A) {
		Node B;
		Node T1;
		Node T2;
		Node T3;

		// Assign left and right of Node
		if (A instanceof AVLRootNode) {

			B = ((AVLRootNode) A).left;
			T3 = ((AVLRootNode) A).right;
		} else {
			B = ((AVLInternalNode) A).left;
			T3 = ((AVLInternalNode) A).right;
		}

		// Assign left of right child of node and right of right child of node
		if (B instanceof AVLInternalNode) {
			T1 = ((AVLInternalNode) B).left;
			T2 = ((AVLInternalNode) B).right;

		} else {

			T2 = null;
			T1 = null;
		}

		// CASE First: A is Root and B is Internal
		if (A instanceof AVLRootNode && B instanceof AVLInternalNode) {
			B = changeNodeToRootNode(B);
			A = changeNodeToInternalNode(A);

			((AVLInternalNode) A).left = T2;
			((AVLInternalNode) A).right = T3;

			((AVLInternalNode) A).height = calculateHeight(((AVLInternalNode) A));

			((AVLRootNode) B).right = A;
			((AVLRootNode) B).left = T1;

			((AVLRootNode) B).height = calculateHeight(((AVLRootNode) B));

			return B;
		}

		// CASE Second: A and B both Internal
		if (A instanceof AVLInternalNode && B instanceof AVLInternalNode) {

			((AVLInternalNode) A).left = T2;
			((AVLInternalNode) A).right = T3;

			((AVLInternalNode) A).height = calculateHeight(((AVLInternalNode) A));

			((AVLInternalNode) B).right = A;
			((AVLInternalNode) B).left = T1;

			((AVLInternalNode) B).height = calculateHeight(((AVLInternalNode) B));

			return B;
		}

		// CASE Third: A is Internal and B is Leaf
		if (A instanceof AVLInternalNode && B instanceof AVLLeafNode) {
			B = changeNodeToInternalNode(B);
			A = changeNodeToLeafNode(A);
			// There is no need to change in LeafNode
			((AVLInternalNode) B).right = A;
			((AVLInternalNode) B).left = T1;
			((AVLInternalNode) B).height = calculateHeight(((AVLInternalNode) B));

			return B;
		}

		return B;
	}

	// This takes Node as a input and return AVLInternalNode
	AVLInternalNode changeNodeToInternalNode(Node node) {
		int height;
		if (node instanceof AVLLeafNode) {
			height = ((AVLLeafNode) node).height;
		} else if (node instanceof AVLRootNode) {
			height = ((AVLRootNode) node).height;
		} else {
			return ((AVLInternalNode) node);
		}

		node = new AVLInternalNode(node.data);
		((AVLInternalNode) node).height = height;

		return ((AVLInternalNode) node);
	}

	// This takes Node as a input and return AVLRootNode
	AVLRootNode changeNodeToRootNode(Node node) {
		int height;
		if (node instanceof AVLLeafNode) {
			height = ((AVLLeafNode) node).height;
		} else if (node instanceof AVLRootNode) {
			return ((AVLRootNode) node);
		} else {
			height = ((AVLInternalNode) node).height;
		}

		node = new AVLRootNode(node.data);
		((AVLRootNode) node).height = height;
		return ((AVLRootNode) node);
	}

	// This takes Node as a input and return AVLLeafNode
	AVLLeafNode changeNodeToLeafNode(Node node) {
		return new AVLLeafNode(node.data);
	}

}
