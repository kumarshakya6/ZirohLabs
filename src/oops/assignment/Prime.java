package oops.assignment;

public class Prime implements IOperator {
	IOperator successor;

	public void setSuccessor(IOperator successor) {
		if (this.successor == null) {
			this.successor = successor;
		} else {
			this.successor.setSuccessor(successor);
		}

	}

	public void checkNumber(int... a) {
		int key = a[0];
		if (isPrime(key)) {
			System.out.println(key + " is prime ");
		} else {
			System.out.println(key + " is not prime ");
		}
		if (successor != null) {
			successor.checkNumber(a);
		}
	}

	// Check prime number
	private boolean isPrime(int num) {

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
