package org.pattern.strategy;

public class PrintReverse implements Print {

	@Override
	public void process(String name) {
		System.out.println("Print Reverse");
		for (int i = name.length() - 1; i >= 0; i--) {
			System.out.println(name.charAt(i));
		}
	}

}
