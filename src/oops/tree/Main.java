package oops.tree;

import java.util.List;

public class Main {
	public static void main(String[] args) throws EmptyTreeException {

		BST tree = new BST();
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);
		tree.insert(30);
		tree.insert(-20);
		tree.insert(300);

		System.out.println(tree.search(20));

		System.out.println("Get In Order Traversal:");
		List<Integer> elements = tree.getInOrder();
		System.out.println();
		for (Integer e : elements) {
			System.out.print(e + " ");
		}
		System.out.println();
		System.out.println(tree.getMinValue());

		elements = tree.getInOrder();
		System.out.println();
		for (Integer e : elements) {
			System.out.print(e + " ");
		}
		System.out.println(tree.getMaxValue());

//		Node node = new InternalNode(10);
//
//		if (node instanceof RootNode) {
//			System.out.println("This is root node");
//		} else if (node instanceof InternalNode) {
//			System.out.println("This is Internal node");
//		} else if (node instanceof LeafNode) {
//			System.out.println("This is LeafNode");
//		}

	}

}
