/**
 * 
 */
package oops.tree;

/**
 * @author vicky
 *
 */
public class BST /* extends Tree */ {

	// /////@Override
//	void insert(Node node) {
//
//	}

	// /////@Override
	public Node search(Node root) {
		System.out.println(((RootNode) root).left.data);
		return ((RootNode) root).left;

	}
//	public Node search(Node node, int k) {
//		if (node.left == null && node.right == null) {
//			return node;
//		} else if (node.data == k) {
//			return node;
//
//		} else if (node.data < k) {
//
//			return search(node.right, k);
//		} else {
//
//			return search(node.left, k);
//		}
//
//	}

	///// @Override
	void insert(Node root, Node newNode) {
		// TODO Auto-generated method stub

	}

	///// @Override
	Node findMinNode(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	///// @Override
	Node findMaxNode(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	///// @Override
//	void inOrder(Node root) {
//		if (root == null) {
//			return;
//		}
//		inOrder(root.left);
//		System.out.print(root.data + " ");
//		inOrder(root.right);
//
//	}

	///// @Override
	void preOrder(Node root) {
		// TODO Auto-generated method stub

	}

	///// @Override
	void postOrder(Node root) {
		// TODO Auto-generated method stub

	}

}
