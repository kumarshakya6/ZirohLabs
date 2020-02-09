package oops.tree;

public class InternalNode extends Node {
	Node parent, left, right;

	public InternalNode(int data) {
		super(data);
		parent = null;

	}

}
