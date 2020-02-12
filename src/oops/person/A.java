package oops.person;

import java.util.ArrayList;
import java.util.List;

/**
 * This is class implemented based on OBSERVER PATTERN, PUBLISH and SUBSCRIBE
 * concepts
 * 
 * There are two INTERFACE and three CLASS with class A
 * 
 * There are also used the concept of GENERIC
 */
public class A<T extends Comparable<T>> implements Container<T> {
	private T value;
	private List<Person<T>> container = new ArrayList<>();

	public A(T value) {
		this.value = value;

	}

	public void write(T value) {
		if (this.value.compareTo(value) >= 0) {
			System.out.println("Writting.");
		} else {
			for (Person<T> person : container) {
				person.notify(value);
			}
		}

	}

	@Override
	public void add(Person<T> person) {
		container.add(person);
	}

	@Override
	public boolean remove(Person<T> person) {
		return container.remove(person);
	}

}
