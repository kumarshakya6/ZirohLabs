package org.pattern.strategy;

public class PrintDiagonal implements Print {

	@Override
	public void process(String name) {
		System.out.println("Print Diagonal");
		String temp = "";
		for (int i = 0; i < name.length(); i++) {
			System.out.println(temp + name.charAt(i));
			temp += " ";
		}

	}

}
