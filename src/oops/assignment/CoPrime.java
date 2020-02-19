package oops.assignment;

public class CoPrime implements IOperator {
	IOperator successor;

	// Set the successor for next successor

	public void setSuccessor(IOperator successor) {
		if (this.successor == null) {
			this.successor = successor;
		} else {
			this.successor.setSuccessor(successor);
		}

	}

	public int[] checkNumber(int... a) {
		int key = a[0];
		int keyOfNode = a[1];
		if (isCoPrime(key, keyOfNode)) {
			System.out.println(key + " and " + keyOfNode + " " + "numbers are Co-Prime");

		} else {
			System.out.println(key + " and " + keyOfNode + " " + "numbers are not Co-Prime");
		}
		if (successor != null) {
			return successor.checkNumber(a);
		} else {
			return a;
		}
	}

	private boolean isCoPrime(int num1, int num2) {
		if (gcd(num1, num2) <= 1) {
			return true;
		} else {
			return false;
		}
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
