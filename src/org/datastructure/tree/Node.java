/**
 * 
 */
package org.datastructure.tree;

/*
 * 
 * This is the basic node class of tree It have tree properties left of Node it
 * is Node type right of Node it is Node type data of Node it is integer type
 */
public class Node {
	int data;

	Node left, right;

	/*
	 * This is the user define contractor It has only one parameter that data it's
	 * integer type
	 */
	public Node(int data) {
		right = left = null;
		this.data = data;

	}

}
