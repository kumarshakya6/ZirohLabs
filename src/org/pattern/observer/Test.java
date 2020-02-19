package org.pattern.observer;

public class Test {

	public static void main(String[] args) {
		A<Integer> a = new A<>(10);
		a.add(new PersonA<>());
		a.add(new PersonB<>());
		a.add(new PersonC<>());
		System.out.println("First write method");
		a.write(10);
		System.out.println("\n\nSecond write method");
		a.write(30);
	}

}
