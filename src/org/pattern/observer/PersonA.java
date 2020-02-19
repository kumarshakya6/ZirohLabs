package org.pattern.observer;

public class PersonA<T> implements Person<T> {
	T value;

	@Override
	public void notify(T value) {
		System.out.println("Person A  got notification: ");
		this.value = value;

	}

}
