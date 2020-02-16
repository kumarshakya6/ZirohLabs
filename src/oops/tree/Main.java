package oops.tree;

public class Main {
	public static void main(String[] args) throws EmptyTreeException {

		Node node1 = new LeafNode(10);
		System.out.println("First one is true");
		System.out.println(node1 instanceof LeafNode);
		System.out.println(node1 instanceof RootNode);
		System.out.println(node1 instanceof InternalNode);

		Node node2 = new RootNode(20);
		System.out.println("second one is true");

		System.out.println(node2 instanceof LeafNode);
		System.out.println(node2 instanceof RootNode);
		System.out.println(node2 instanceof InternalNode);

		Node node3 = new InternalNode(30);
		System.out.println("third one is true");

		System.out.println(node3 instanceof LeafNode);
		System.out.println(node3 instanceof RootNode);
		System.out.println(node3 instanceof InternalNode);
	}

}
