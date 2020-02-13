package org.pattern.strategy;

public class DemoMain {
	public static void main(String[] args) {

		Letter l = new Letter("Shakya");

		l.setStrategy(new PrintReverse());
		l.apply();

		l.setStrategy(new PrintVertical());
		l.apply();

		l.setStrategy(new PrintDiagonal());
		l.apply();

	}
}
