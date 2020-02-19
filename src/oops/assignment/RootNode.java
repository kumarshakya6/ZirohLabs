package oops.assignment;

public class RootNode extends Node {
	Node left, right;

	public RootNode(int key, IOperator pipe) {
		super(key, pipe);
		left = right = null;
	}

}
