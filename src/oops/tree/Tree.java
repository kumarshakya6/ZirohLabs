/**
 * 
 */
package oops.tree;

/**
 * @author vicky
 *
 */
abstract class Tree {

	abstract Node search(Node node, int k);

	abstract void insert(Node node);

	abstract void insert(Node root, Node newNode);

	abstract Node findMinNode(Node root);

	abstract Node findMaxNode(Node root);

	abstract void inOrder(Node root);

	abstract void preOrder(Node root);

	abstract void postOrder(Node root);

}
