package oops.tree;

public class AVLRootNode extends RootNode {
	int height;

	public AVLRootNode(int data) {
		super(data);
		height = 0;
	}
}
