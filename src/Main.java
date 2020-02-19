import oops.assignment.BST;
import oops.assignment.CoPrime;
import oops.assignment.EvenOdd;
import oops.assignment.ParentEvenOdd;
import oops.assignment.Prime;
import oops.tree.EmptyTreeException;

public class Main {

	public static void main(String[] args) throws EmptyTreeException {

		BST tree = new BST();

		Prime prime = new Prime();
		EvenOdd evenOdd = new EvenOdd();
		CoPrime coPrime = new CoPrime();
		ParentEvenOdd parentEvevOdd = new ParentEvenOdd();
		prime.setSuccessor(evenOdd);
		evenOdd.setSuccessor(coPrime);
		coPrime.setSuccessor(parentEvevOdd);

		System.out.println("This is the output of Assignment:\n");
		System.out.println("First Insertion................");
		tree.insert(5, prime);
		System.out.println("Second Insertion.................");

		tree.insert(7, evenOdd);
		System.out.println("Third Insertion..................");

		tree.insert(10, evenOdd);
		System.out.println("Fourth Insertion................");

		tree.insert(8, prime);

//		AVLTree tree = new AVLTree();
//		tree.insert(10);
//		tree.insert(20);
//		tree.insert(30);
//
//		tree.insert(90);
//		tree.insert(800);
//		tree.insert(7700);
//		tree.insert(550005);
//		tree.insert(9999925);
//		tree.insert(309980);
//		tree.insert(40);
//		tree.insert(60);
//		tree.insert(735);
//		tree.insert(556);
//		tree.insert(2775);
//		tree.insert(330);
//		tree.insert(490);
//		tree.insert(-10);
//		tree.insert(400);
//		tree.insert(800);
//		tree.insert(30998320);
//		tree.insert(402333);
//		System.out.println(tree.getHeight());
//
//		System.out.println(tree.search(20));
//
//		List<Integer> list1 = tree.getInOrder();
//
//		for (int e : list1) {
//			System.out.print(e + " ");
//		}
//		System.out.println();

	}

}

//class A {
//	protected int num1 = 10;
//
//}
//
//class B extends A {
//
//}
//
//class C extends B {
//
//}
