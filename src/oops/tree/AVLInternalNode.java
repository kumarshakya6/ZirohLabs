package oops.tree;

public class AVLInternalNode extends InternalNode {
	int height;

	public AVLInternalNode(int data) {
		super(data);
		height = 0;
	}
}
