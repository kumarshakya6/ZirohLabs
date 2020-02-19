/**
 * 
 */
package oops.assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shakya
 * 
 *         This class has these methods: INSERT, SEARCH, DELETE,GET MINVALUE,
 *         GET MAXVALUE, GET INORDER, GET PREORDER and GETPOSTORDER
 *
 */

public class BST {

	protected Node root;

	protected List<Integer> elements;

	// Variable for pipeline

	protected int keyOfParent = 0;
	protected int keyOfParentOfParent = 0;

	///// @Override
	/**
	 * This method takes one parameter integer type and adds element into the tree
	 * 
	 * @param key
	 */
	public void insert(int key, IOperator pipe) {
		// Root null,create RootNode and return it
		if (root == null) {
			root = new RootNode(key, pipe);
			return;
		}
		// Root not null call insert recursive method with two parameters root and key
		root = insert(root, key, pipe);
	}

	// Define insert recursive method
	private Node insert(Node current, int key, IOperator pipe) {

		// Pipeline code written here:
		// Create Pipeline object
		Pipeline operator = new Pipeline(current.pipe);

		// Call EXCUTE method
		operator.excute(key, current.key, keyOfParent, keyOfParentOfParent);
		System.out.println("*********************************************");

		if (keyOfParent == 0) {
			keyOfParent = current.key;
		} else {
			keyOfParentOfParent = keyOfParent;
			keyOfParent = current.key;
		}

		// Data exist return
		if (current.key == key) {
			return current;
		}

		// Node is LeafNode
		if (current instanceof LeafNode) {
			// Converts Leaf Node to Internal Node
			current = leafToInternal((LeafNode) current);

			// Left subtree
			if (current.key > key) {
				Node newNode = new LeafNode(key, pipe);
				((LeafNode) newNode).parent = current;
				((InternalNode) current).left = newNode;

				// Right subtree
			} else {
				Node newNode = new LeafNode(key, pipe);
				((LeafNode) newNode).parent = current;
				((InternalNode) current).right = newNode;

			}
			return current;

			// Node is RootNode
		} else if (current instanceof RootNode) {
			// Left subtree
			if (current.key > key) {
				if (((RootNode) current).left != null) {
					((RootNode) current).left = insert(((RootNode) current).left, key, pipe);

				} else {
					Node newNode = new LeafNode(key, pipe);
					((LeafNode) newNode).parent = current;
					((RootNode) current).left = newNode;
					return current;
				}

				// Right subtree
			} else {
				if (((RootNode) current).right != null) {
					((RootNode) current).right = insert(((RootNode) current).right, key, pipe);

				} else {
					Node newNode = new LeafNode(key, pipe);
					((LeafNode) newNode).parent = current;
					((RootNode) current).right = newNode;
					return current;
				}
			}

			// Node is InternalNode
		} else if (current instanceof InternalNode) {
			// Left subtree
			if (current.key > key) {
				if (((InternalNode) current).left != null) {
					((InternalNode) current).left = insert(((InternalNode) current).left, key, pipe);
				} else {
					Node newNode = new LeafNode(key, pipe);
					((LeafNode) newNode).parent = current;
					((InternalNode) current).left = newNode;

					return current;

				}

				// Right subtree
			} else {
				if (((InternalNode) current).right != null) {
					((InternalNode) current).right = insert(((InternalNode) current).right, key, pipe);

				} else {
					Node newNode = new LeafNode(key, pipe);
					((LeafNode) newNode).parent = current;
					((InternalNode) current).right = newNode;

					return current;
				}
			}
		}

		return current;
	}

	// TODO there is two error, I have to handle it
	// Conversion method LeafNode to InternalNode
	InternalNode leafToInternal(LeafNode leaf) {
		return new InternalNode(leaf.key, leaf.pipe);
	}

	// Node conversion method InternalNode to LeafNode
	LeafNode internalToLeaf(InternalNode internal) {
		return new LeafNode(internal.key, internal.pipe);
	}

	/**
	 * This method takes input integer type key and search it and returns boolean.
	 * if exists returns true else false;
	 * 
	 * @param key
	 * @return boolean
	 */

	public boolean search(int key) {

		return search(root, key);
	}

	private boolean search(Node current, int key) {

		// BASE CASE
		// Current Node is null return false
		if (current == null) {
			return false;
		}
		// BASE CASE
		if (current.key == key) {
			return true;
		}
		// BASE CASE
		if (current instanceof LeafNode) {
			return false;
		}

		// Recursive CASE for Left subtree
		// Check Leaf subtree
		if (current.key > key) {

			// Current is RootNode
			if (current instanceof RootNode) {

				return search(((RootNode) current).left, key);

			} else {

				return search(((InternalNode) current).left, key);

			}

			// Recursive CASE for Right subtree
		} else {
			if (current instanceof RootNode) {

				return search(((RootNode) current).right, key);

			} else {

				return search(((InternalNode) current).right, key);

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

	public void delete(int key) {
		if (root == null) {
			return;
		}
		root = delete(root, key);

	}

	// This is delete method using recursion
	private Node delete(Node current, int key) {

		if (current instanceof LeafNode && current.key == key) {
			current = null;
			return current;
		}
		if (current instanceof RootNode && current.key == key && ((RootNode) current).left == null
				&& ((RootNode) current).right == null) {
			current = null;
			return current;
		}

		// If key is less than current key move left subtree
		if (current.key > key) {

			if (current instanceof RootNode) {
				((RootNode) current).left = delete(((RootNode) current).left, key);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).left = delete(((InternalNode) current).left, key);
			}

			// If key is greater than current key move right subtree
		} else if (current.key < key) {

			if (current instanceof RootNode) {
				((RootNode) current).right = delete(((RootNode) current).right, key);
			} else if (current instanceof InternalNode) {
				((InternalNode) current).right = delete(((InternalNode) current).right, key);
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
				current.key = getMinValue(((RootNode) current).right);

				((RootNode) current).right = delete(((RootNode) current).right, current.key);

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

				current.key = getMinValue(((InternalNode) current).right);

				((InternalNode) current).right = delete(((InternalNode) current).right, current.key);

			}

		}

		// If InternalNode has both left and right null than makes it LeafNode
		if (current instanceof InternalNode) {
			if (((InternalNode) current).left == null && ((InternalNode) current).right == null) {
				current = new LeafNode(current.key, current.pipe);
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
			return current.key;
		} else if (current instanceof RootNode) {
			if (((RootNode) current).left != null) {
				return getMinValue(((RootNode) current).left);
			} else {
				return current.key;
			}
		} else {
			if (((InternalNode) current).left != null) {
				return getMinValue(((InternalNode) current).left);
			} else {
				return current.key;
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
			return current.key;
		} else if (current instanceof RootNode) {
			if (((RootNode) current).right != null) {
				Node right = ((RootNode) current).right;
				return getMaxValue(right);
			}

			return current.key;

		} else {
			if (((InternalNode) current).right != null) {
				Node right = ((InternalNode) current).right;
				return getMaxValue(right);
			}
			return current.key;

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
			elements.add(current.key);
//			return;

		} else if (current instanceof RootNode) {
			// Visit left subtree
			if (((RootNode) current).left != null) {
				getInOrder(((RootNode) current).left);

			}

			// Print current key
			elements.add(current.key);

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
			elements.add(current.key);

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
			elements.add(current.key);
			return;

		}
		if (current instanceof RootNode) {

			// Print current key
			elements.add(current.key);

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
			elements.add(current.key);

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

			elements.add(current.key);
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
			elements.add(current.key);

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
			elements.add(current.key);
		}

	}

}
