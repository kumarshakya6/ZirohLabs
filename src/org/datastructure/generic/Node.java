/**
 * 
 */
package org.datastructure.generic;

/*
 * 
 * This is the basic node class of tree It have tree properties left of Node it
 * is Node type right of Node it is Node type data of Node it is generic type
 */
public class Node<T> {
	T data;

	Node<T> left, right;

	/*
	 * This is the user define contractor It has only one parameter that data it's
	 * Generic type
	 */
	public Node(T data) {
		right = left = null;
		this.data = data;

	}

}