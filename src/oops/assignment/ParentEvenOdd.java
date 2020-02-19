package oops.assignment;

public class ParentEvenOdd implements IOperator {

	// Seccessor for next method call
	IOperator successor;

	@Override
	public int[] checkNumber(int... a) {

		int keyOfParent = a[2];
		int keyOfParentOfParent = a[3];

		// Parent and Parent of Parent exists only
		if (keyOfParent != 0 && keyOfParentOfParent != 0)
			if (keyOfParent % 2 == 0 && keyOfParentOfParent % 2 == 0) {
				System.out.println("Even and Even");
			} else if (keyOfParent % 2 == 0 && keyOfParentOfParent % 2 == 1) {
				System.out.println("Even and Odd");
			} else if (keyOfParent % 2 == 1 && keyOfParentOfParent % 2 == 0) {
				System.out.println("Odd and Even");
			} else {
				System.out.println("Odd and Odd");
			}

		return a;
	}

	@Override
	public void setSuccessor(IOperator successor) {
		if (this.successor == null) {
			this.successor = successor;
		} else {
			this.successor.setSuccessor(successor);
		}

	}

}
