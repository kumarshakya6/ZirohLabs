/**
 * 
 */
package oops.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vicky
 * 
 *         This class has these methods: INSERT, SEARCH, DELETE,GET MINVALUE,
 *         GET MAXVALUE, GET INORDER, GET PREORDER and GETPOSTORDER
 *
 */

public class BST {

	Node root;
	protected List<Integer> elements;

	///// @Override
	/**
	 * This method takes one parameter integer type and adds element into the tree
	 * 
	 * @param key
	 */
	public void insert(int data) {
		// Root null,create RootNode and return it
		if (root == null) {
			root = new RootNode(data);
			return;
		}
		// Root not null call insert recursive method with two parameters root and key
		root = insert(root, data);
	}

	// Define insert recursive method
	private Node insert(Node current, int data) {

		// Data exist return
		if (current.data == data) {
			return current;
		}

		// Node is LeafNode
		if (current instanceof LeafNode) {
			// Converts Leaf Node to Internal Node
			current = leafToInternal((LeafNode) current);

			// Left subtree
			if (current.data > data) {
				Node newNode = new LeafNode(data);
				((LeafNode) newNode).parent = current;
				((InternalNode) current).left = newNode;

				// Right subtree
			} else {
				Node newNode = new LeafNode(data);
				((LeafNode) newNode).parent = current;
				((InternalNode) current).right = newNode;

			}
			return current;

			// Node is RootNode
		} else if (current instanceof RootNode) {
			// Left subtree
			if (current.data > data) {
				if (((RootNode) current).left != null) {
					((RootNode) current).left = insert(((RootNode) current).left, data);

				} else {
					Node newNode = new LeafNode(data);
					((LeafNode) newNode).parent = current;
					((RootNode) current).left = newNode;
					return current;
				}

				// Right subtree
			} else {
				if (((RootNode) current).right != null) {
					((RootNode) current).right = insert(((RootNode) current).right, data);

				} else {
					Node newNode = new LeafNode(data);
					((LeafNode) newNode).parent = current;
					((RootNode) current).right = newNode;
					return current;
				}
			}

			// Node is InternalNode
		} else if (current instanceof InternalNode) {
			// Left subtree
			if (current.data > data) {
				if (((InternalNode) current).left != null) {
					((InternalNode) current).left = insert(((InternalNode) current).left, data);
				} else {
					Node newNode = new LeafNode(data);
					((LeafNode) newNode).parent = current;
					((InternalNode) current).left = newNode;

					return current;

				}

				// Right subtree
			} else {
				if (((InternalNode) current).right != null) {
					((InternalNode) current).right = insert(((InternalNode) current).right, data);

				} else {
					Node newNode = new LeafNode(data);
					((LeafNode) newNode).parent = current;
					((InternalNode) current).right = newNode;

					return current;
				}
			}
		}

		return current;
	}

	// Conversion method LeafNode to InternalNode
	InternalNode leafToInternal(LeafNode leaf) {
		return new InternalNode(leaf.data);
	}

	// Node conversion method InternalNode to LeafNode
	LeafNode internalToLeaf(InternalNode internal) {
		return new LeafNode(internal.data);
	}

	/**
	 * This method takes input integer type key and search it and returns boolean.
	 * if exists returns true else false;
	 * 
	 * @param key
	 * @return boolean
	 */

	public boolean search(int data) {

		return search(root, data);
	}

	private boolean search(Node current, int data) {

		// BASE CASE
		// Current Node is null return false
		if (current == null) {
			return false;
		}
		// BASE CASE
		if (current.data == data) {
			return true;
		}
		// BASE CASE
		if (current instanceof LeafNode) {
			return false;
		}

		// Recursive CASE for Left subtree
		// Check Leaf subtree
		if (current.data > data) {

			// Current is RootNode
			if (current instanceof RootNode) {

				return search(((RootNode) current).left, data);

			} else {

				return search(((InternalNode) current).left, data);

			}

			// Recursive CASE for Right subtree
		} else {
			if (current instanceof RootNode) {

				return search(((RootNode) current).right, data);

			} else {

				return search(((InternalNode) current).right, data);

			}

		}

		// return false;

	}

	/**
	 * This method takes one parameter integer type and fetch the given key delete
	 * it
	 * 
	 * @param key
	 */

	public void delete(int data) {
		if (root == null) {
			return;
		}
		root = delete(root, data);

	}

	// This is delete method using recursion
	private Node delete(Node current, int data) {

		if (current instanceof LeafNode && current.data == data) {
			current = null;
			return current;
		}
		if (current instanceof RootNode && current.data == data && ((RootNode) current).left == null
				&& ((RootNode) current).right == null) {
			current = null;
			return current;
		}

		// If key is less than current key move left subtree
		if (current.data > data) {

			if (current instanceof RootNode) {
				((RootNode) current).left = delete(((RootNode) current).left, data);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).left = delete(((InternalNode) current).left, data);
			}

			// If key is greater than current key move right subtree
		} else if (current.data < data) {

			if (current instanceof RootNode) {
				((RootNode) current).right = delete(((RootNode) current).right, data);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).right = delete(((InternalNode) current).right, data);
			}

			// If found the key
		} else {
			// If Node is LeafNode
			if (current instanceof LeafNode) {
				current = null;
				return current;

				// If Node is RootNode
			} else if (current instanceof RootNode) {
				if (((RootNode) current).left == null) {
					current = ((RootNode) current).right;
					return current;
				} else if (((RootNode) current).right == null) {
					current = ((RootNode) current).left;
					return current;
				}
				current.data = getMinValue(((RootNode) current).right);

				((RootNode) current).right = delete(((RootNode) current).right, current.data);

			}
			// If Node is InternalNode
			else if (current instanceof InternalNode) {
				if (((InternalNode) current).left == null) {

					Node parent = ((InternalNode) current).parent;
					current = ((InternalNode) current).right;

					((InternalNode) current).parent = parent;
					return current;

				} else if (((InternalNode) current).right == null) {
					Node parent = ((InternalNode) current).parent;
					current = ((InternalNode) current).left;
					((InternalNode) current).parent = parent;
					return current;
				}

				current.data = getMinValue(((InternalNode) current).right);

				((InternalNode) current).right = delete(((InternalNode) current).right, current.data);

			}

		}

		// If InternalNode has both left and right null than makes it LeafNode
		if (current instanceof InternalNode) {
			if (((InternalNode) current).left == null && ((InternalNode) current).right == null) {
				current = new LeafNode(current.data);
			}

		}
		return current;

	}

	/**
	 * This method fetch the minimum value of the tree and return it. If the tree is
	 * null/empty it will throw EmptyTreeException
	 * 
	 * @return Integer
	 * @throws EmptyTreeException
	 */
	public int getMinValue() throws EmptyTreeException {
		if (root != null)
			return getMinValue(root);
		throw new EmptyTreeException("Tree is empty.");
	}

	private int getMinValue(Node current) {
		if (current instanceof LeafNode) {
			return current.data;
		} else if (current instanceof RootNode) {
			if (((RootNode) current).left != null) {
				return getMinValue(((RootNode) current).left);
			} else {
				return current.data;
			}
		} else {
			if (((InternalNode) current).left != null) {
				return getMinValue(((InternalNode) current).left);
			} else {
				return current.data;
			}
		}
	}

	/**
	 * This method fetch the maximum value of the tree and return it. If the tree is
	 * null/empty it will throw EmptyTreeException
	 * 
	 * @return Integer
	 * @throws EmptyTreeException
	 */
	public int getMaxValue() throws EmptyTreeException {
		if (root != null)
			return getMaxValue(root);
		throw new EmptyTreeException("Tree is empty.");
	}

	private int getMaxValue(Node current) {
		if (current instanceof LeafNode) {
			return current.data;
		} else if (current instanceof RootNode) {
			if (((RootNode) current).right != null) {
				Node right = ((RootNode) current).right;
				return getMaxValue(right);
			}

			return current.data;

		} else {
			if (((InternalNode) current).right != null) {
				Node right = ((InternalNode) current).right;
				return getMaxValue(right);
			}
			return current.data;

		}
	}

	/**
	 * This method visits whole tree in INORDER and return the list of elements
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getInOrder() {
		elements = new ArrayList<>();
		if (root == null) {
			return elements;
		}
		getInOrder(root);
		return elements;
	}

	private void getInOrder(Node current) {

		if (current instanceof LeafNode) {
			elements.add(current.data);
//			return;

		} else if (current instanceof RootNode) {
			// Visit left subtree
			if (((RootNode) current).left != null) {
				getInOrder(((RootNode) current).left);

			}

			// Print current key
			elements.add(current.data);

			// Visit right subtree
			if (((RootNode) current).right != null) {
				getInOrder(((RootNode) current).right);
			}

		} else {
			// Visit left subtree
			if (((InternalNode) current).left != null) {
				getInOrder(((InternalNode) current).left);
			}

			// Print current key
			elements.add(current.data);

			// Visit right subtree
			if (((InternalNode) current).right != null) {
				getInOrder(((InternalNode) current).right);
			}

		}

	}

	/**
	 * This method visits tree in PREORDER and returns the list of elements
	 * 
	 * @return List<Integer>
	 */
	public List<Integer> getPreOrder() {
		elements = new ArrayList<>();
		if (root == null) {
			return elements;
		}
		getPreOrder(root);
		return elements;
	}

	private void getPreOrder(Node current) {

		if (current instanceof LeafNode) {
			elements.add(current.data);
			return;

		}
		if (current instanceof RootNode) {

			// Print current key
			elements.add(current.data);

			// Visit left subtree
			if (((RootNode) current).left != null) {
				getPreOrder(((RootNode) current).left);

			}

			// Visit right subtree
			if (((RootNode) current).right != null) {
				getPreOrder(((RootNode) current).right);
			}

		} else {

			// Print current key
			elements.add(current.data);

			// Visit left subtree
			if (((InternalNode) current).left != null) {
				getPreOrder(((InternalNode) current).left);
			}

			// Visit right subtree
			if (((InternalNode) current).right != null) {
				getPreOrder(((InternalNode) current).right);
			}

		}
	}

	/**
	 * This method visits the tree in POSTORDER and returns the list of elements
	 * 
	 * @return List<Integer>
	 */

	public List<Integer> getPostOrder() {
		elements = new ArrayList<>();
		if (root == null) {
			return elements;
		}
		getPostOrder(root);
		return elements;
	}

	private void getPostOrder(Node current) {

		if (current instanceof LeafNode) {

			elements.add(current.data);
			return;

		}
		if (current instanceof RootNode) {

			// Visit left subtree
			if (((RootNode) current).left != null) {
				getPostOrder(((RootNode) current).left);

			}

			// Visit right subtree
			if (((RootNode) current).right != null) {
				getPostOrder(((RootNode) current).right);
			}

			// Print current key
			elements.add(current.data);

		} else {

			// Visit left subtree
			if (((InternalNode) current).left != null) {
				getPostOrder(((InternalNode) current).left);
			}

			// Visit right subtree
			if (((InternalNode) current).right != null) {
				getPostOrder(((InternalNode) current).right);
			}

			// Print current key
			elements.add(current.data);
		}

	}

}
