/**
 * 
 */
package org.datastructure.tree;

/*
 * 
 * This is the basic node class of tree It have tree properties left of Node it
 * is Node type right of Node it is Node type key of Node it is integer type
 */
public class Node {
	int data;

	public Node left, right, parent;

	/*
	 * This is the user define contractor It has only one parameter that key it's
	 * integer type
	 */
	public Node(int data) {
		right = left = parent = null;
		this.data = data;

	}

}
