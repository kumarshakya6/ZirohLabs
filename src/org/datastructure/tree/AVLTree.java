/**
 * 
 */
package org.datastructure.tree;

/**
 * @author vicky
 *
 */
public class AVLTree extends BinarySearchTree {

	/**
	 * 
	 */
	@Override

	public void insert(int data) {
		root = insert(root, data);

	}

	private Node insert(Node current, int data) {
		if (current == null) {
			return new AVLNode(data);
		}

		if (data < current.data) {
			current.left = insert(current.left, data);
		} else if (data > current.data) {
			(current).right = insert(current.right, data);
		} else {
			return current;
		}

		((AVLNode) current).height = 1 + Math.max(height(current.left), height(current.right));

		int balance = getBalance(current);

		// Right Right rotation
		if (balance < -1 && getBalance(current.right) == -1) {
			return rightRotation(current);
		}
		// Right Left Rotation
		if (balance < -1 && getBalance(current.right) == 1) {
			return rightLeftRotation(current);
		}

		// Left Left Rotation
		if (balance > 1 && getBalance(current.left) == 1) {
			return leftRotation(current);
		}

		// Left Right Rotation
		if (balance > 1 && getBalance(current.left) == -1) {
			return leftRightRotation(current);
		}

		return current;
	}

	public void delete(int data) {
		root = delete(root, data);
	}

	private Node delete(Node current, int data) {
		// BASE CASE
		if (current == null) {
			return current;
		}
		if (current.data > data) {
			current.left = delete(current.left, data);
		} else if (current.data < data) {
			current.right = delete(current.right, data);
		} else {
			if (current.left == null && current.right == null) {
				current = null;
				return current;
			} else if (current.left == null) {
				current = current.right;
			} else if (current.right == null) {
				current = current.left;
			} else {
				current.data = getMinValue(current.right);

				current.right = delete(current.right, current.data);
			}
		}

		((AVLNode) current).height = 1 + Math.max(height(current.left), height(current.right));

		int balance = getBalance(current);

		// Right Right rotation
		if (balance < -1 && getBalance(current.right) == -1) {
			return rightRotation(current);
		}
		// Right Left Rotation
		if (balance < -1 && getBalance(current.right) == 1) {
			return rightLeftRotation(current);
		}

		// Left Left Rotation
		if (balance > 1 && getBalance(current.left) == 1) {
			return leftRotation(current);
		}

		// Left Right Rotation
		if (balance > 1 && getBalance(current.left) == -1) {
			return leftRightRotation(current);
		}

		return current;
	}

//This method for calculates height and return height of the node
	int height(Node current) {
		if (current == null) {
			return 0;
		}
		return ((AVLNode) current).height;
	}

	int getBalance(Node current) {
		if (current == null) {
			return 0;
		}

		return height(current.left) - height(current.right);
	}

	// Right Right rotation
	Node rightRotation(Node node) {
		Node child = node.right;
		Node leftOfChild = child.left;

		// Apply rotation
		child.left = node;
		node.right = leftOfChild;

		// Calculate height
		((AVLNode) child).height = 1 + Math.max(height(child.left), height(child.right));
		((AVLNode) node).height = 1 + Math.max(height(node.left), height(node.right));

		return child;
	}

//Left Left rotation
	Node leftRotation(Node node) {
		Node child = node.left;
		Node rightOfChild = child.right;

		// Apply rotation
		child.right = node;
		node.left = rightOfChild;

		// Calculate height

		((AVLNode) child).height = 1 + Math.max(height(child.left), height(child.right));
		((AVLNode) node).height = 1 + Math.max(height(node.left), height(node.right));

		return child;
	}

	// Left Right rotation
	Node leftRightRotation(Node node) {

		// Right rotation
		node.left = rightRotation(node.left);
		// Left rotation
		return leftRotation(node);
	}

	// Right Left rotation
	Node rightLeftRotation(Node node) {
		// Left rotation
		node.right = leftRotation(node.right);
		// Right rotation
		return rightRotation(node);
	}

}
