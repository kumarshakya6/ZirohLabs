package org.pattern.observer;

public class PersonB<T> implements Person<T> {
	T value;

	@Override
	public void notify(T value) {
		System.out.println("Person B got notification :");
		this.value = value;

	}

}
