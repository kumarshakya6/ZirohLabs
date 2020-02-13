package org.pattern.strategy;

public class PrintVertical implements Print {

	@Override
	public void process(String name) {
		System.out.println("Print Vertical");
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}

	}

}
