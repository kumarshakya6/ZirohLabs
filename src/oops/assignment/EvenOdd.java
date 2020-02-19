package oops.assignment;

public class EvenOdd implements IOperator {
	IOperator successor;

	public void setSuccessor(IOperator successor) {
		if (this.successor == null) {
			this.successor = successor;
		} else {
			this.successor.setSuccessor(successor);
		}

	}

	public int[] checkNumber(int... a) {
		int key = a[0];
		if (isEven(key)) {
			System.out.println(key + " is even");
		} else {
			System.out.println(key + " is odd");
		}
		if (successor != null) {
			return successor.checkNumber(a);
		} else {
			return a;
		}
	}

	private boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}

}
