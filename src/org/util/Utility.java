package org.util;

public class Utility {
	static public boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean coPrime(int a, int b) {
		int c = gcd(a, b);
		if (c == 1) {
			return true;
		}
		return false;
	}

	static public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(a, b % a);
	}

//	static public boolean isOdd(int num) {
//		if (num % 2 == 0) {
//			return false;
//		}
//		return true;
//	}

	public static boolean isEven(int num) {
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}

	public static int max(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

	public static long max(long num1, long num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

	public static double max(double num1, double num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

	public static float max(float num1, float num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

}
