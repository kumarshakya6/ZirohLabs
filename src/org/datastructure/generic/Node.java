/**
 * 
 */
package org.datastructure.generic;

/**
 * This is the node class of tree It have tree properties. left Node reference
 * variable that holds left node of tree right Node reference that holds the
 * right node of tree and key holds the key value of the Node
 */
class Node<T> {
	T data;

	// Declares left and right Node<T> type reference variables
	Node<T> left, right;

	/**
	 * This is contractor It has only one parameter that key value of node
	 */
	Node(T data) {
		right = left = null;
		this.data = data;

	}

}
