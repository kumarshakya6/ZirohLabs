package oops.tree;

public class AVLLeafNode extends LeafNode {
	int height;

	public AVLLeafNode(int data) {
		super(data);
		height = 0;
	}
}
