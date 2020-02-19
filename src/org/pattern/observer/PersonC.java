package org.pattern.observer;

public class PersonC<T> implements Person<T> {
	T value;

	@Override
	public void notify(T value) {
		System.out.println("Person C got notification :");
		this.value = value;
	}

}
