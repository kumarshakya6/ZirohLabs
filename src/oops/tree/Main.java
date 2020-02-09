package oops.tree;

public class Main {
	public static void main(String[] args) {

		// Node node = new InternalNode(30);
		// ((InternalNode)node).

		RootNode root = new RootNode(30);
		root.left = new LeafNode(20);
		BST obj = new BST();
		Node node = obj.search(root);
		// System.out.println(node.data + " " + node.parent);
		// System.out.println(node.getClass());
		String name[] = node.getClass().toString().split("[.]");
		// System.out.println(node.getClass().toString());
		String className = name[(name.length) - 1];
//		if (node instanceof className) {
//
//		}

//		 System.out.println((((Class)className)node).data + " " +
//		((name[name.length-1])node).parent);

//		root.left = new InternalNode(20);
//		((InternalNode) root.left).parent = root;
//
//		System.out.println(root.data);
//		System.out.println(root.left.data);
//		System.out.println(((InternalNode) root.left).parent.data);
//
//		// root.left = new Node(20);
//		System.out.println(root.getClass()   );

	}

}
