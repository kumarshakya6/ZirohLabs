package org.datastructure.tree;

public class EmptyStackException extends Exception {
	// serialVersionUID is reducing warning
	private static final long serialVersionUID = 1L;

	EmptyStackException(String s) {

		super(s);
	}
}
