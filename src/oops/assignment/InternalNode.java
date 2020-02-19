package oops.assignment;

public class InternalNode extends Node {
	Node parent, left, right;

	public InternalNode(int key, IOperator pipe) {
		super(key, pipe);
		parent = left = right = null;

	}

}
