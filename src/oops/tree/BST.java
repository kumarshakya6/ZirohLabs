/**
 * 
 */
package oops.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vicky
 *
 */
public class BST /* extends Tree */ {

	protected Node root;
	protected List<Integer> elements;

	///// @Override
	public void insert(int data) {
		if (root == null) {
			root = new RootNode(data);
			return;
		}
		root = insert(root, data);
	}

	private Node insert(Node current, int data) {
		if (current.data == data) {
			return current;
		}
		if (current instanceof LeafNode) {
			current = new InternalNode(current.data);
			if (current.data > data) {
				((InternalNode) current).left = new LeafNode(data);
				((LeafNode) ((InternalNode) current).left).parent = current;

				return current;
			} else {
				((InternalNode) current).right = new LeafNode(data);

				((LeafNode) ((InternalNode) current).right).parent = current;
				return current;
			}
		} else if (current instanceof RootNode) {
			if (current.data > data) {
				if (((RootNode) current).left != null) {
					((RootNode) current).left = insert(((RootNode) current).left, data);

				} else {
					((RootNode) current).left = new LeafNode(data);
					return current;
				}

			} else {
				if (((RootNode) current).right != null) {
					((RootNode) current).right = insert(((RootNode) current).right, data);

				} else {
					((RootNode) current).right = new LeafNode(data);
					return current;
				}
			}
		} else {
			if (current.data > data) {
				if (((InternalNode) current).left != null) {
					((InternalNode) current).left = insert(((InternalNode) current).left, data);
				} else {
					((InternalNode) current).left = (new LeafNode(data).parent = current);

					return current;

				}

			} else {
				if (((InternalNode) current).right != null) {
					((InternalNode) current).right = insert(((InternalNode) current).right, data);

				} else {
					((InternalNode) current).right = (new LeafNode(data).parent = current);

					return current;
				}
			}
		}

		return current;
	}

	/**
	 * This method takes input integer type data and search it and returns boolean.
	 * if exists returns true else false;
	 * 
	 * @param data
	 * @return boolean
	 */

	public boolean search(int data) {
		if (root == null) {
			return false;
		}
		return search(root, data);
	}

	private boolean search(Node current, int data) {
		if (current.data == data) {
			return true;
		}
		if (current instanceof LeafNode) {
			return false;
		}

		if (current.data > data) {

			if (current instanceof RootNode) {
				if (((RootNode) current).left != null) {
					return search(((RootNode) current).left, data);
				}
			} else if (current instanceof InternalNode) {
				if (((InternalNode) current).left != null) {
					return search(((InternalNode) current).left, data);
				}
			}

		} else {
			if (current instanceof RootNode) {
				if (((RootNode) current).right != null) {
					return search(((RootNode) current).right, data);
				}
			} else if (current instanceof InternalNode) {
				if (((InternalNode) current).right != null) {
					return search(((InternalNode) current).right, data);
				}
			}

		}

		return false;

	}

	/**
	 * This method takes one parameter integer type and fetch the given data delete
	 * it
	 * 
	 * @param data
	 */

	public void delete(int data) {
		if (root == null) {
			return;
		}
		root = delete(root, data);

	}

	// This is delete method using recursion
	private Node delete(Node current, int data) {

		// If data is less than current data move left subtree
		if (current.data > data) {

			if (current instanceof RootNode) {
				((RootNode) current).left = delete(((RootNode) current).left, data);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).left = delete(((InternalNode) current).left, data);
			}

			// If data is greater than current data move right subtree
		} else if (current.data < data) {

			if (current instanceof RootNode) {
				((RootNode) current).right = delete(((RootNode) current).right, data);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).right = delete(((InternalNode) current).right, data);
			}

			// If found the data
		} else {
			// If Node is LeafNode
			if (current instanceof LeafNode) {
				current = null;

				// If Node is RootNode
			} else if (current instanceof RootNode) {
				if (((RootNode) current).left == null) {
					current = ((RootNode) current).right;
				} else if (((RootNode) current).right == null) {
					current = ((RootNode) current).left;
				}
				current.data = getMinValue(((RootNode) current).right);

				((RootNode) current).right = delete(((RootNode) current).right, current.data);

			}
			// If Node is InternalNode
			else if (current instanceof InternalNode) {
				if (((InternalNode) current).left == null) {
					/*
					 * This point ERROR found: oops.tree.LeafNode cannot be cast to
					 * oops.tree.InternalNode
					 */
					// Node parent = ((InternalNode) current).parent;
					current = ((InternalNode) current).right;
					// ((InternalNode) current).parent = parent;

				} else if (((InternalNode) current).right == null) {
					// Node parent = ((InternalNode) current).parent;
					current = ((InternalNode) current).left;
					// ((InternalNode) current).parent = parent;
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
				return getMaxValue(((RootNode) current).right);
			} else {
				return current.data;
			}
		} else {
			if (((InternalNode) current).right != null) {
				return getMaxValue(((InternalNode) current).right);
			} else {
				return current.data;
			}
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
			return;

		}
		if (current instanceof RootNode) {
			// Visit left subtree
			if (((RootNode) current).left != null) {
				getInOrder(((RootNode) current).left);

			}

			// Print current data
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

			// Print current data
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

			// Print current data
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

			// Print current data
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

			// Print current data
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

			// Print current data
			elements.add(current.data);
		}

	}

}
