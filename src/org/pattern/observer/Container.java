package org.pattern.observer;

/**
 * This interface Container that has two methods one is add to use add element
 * into container another one is remove that is used to delete element from the
 * container
 */
public interface Container<T> {

	/**
	 * This method is used to add new element into the container it has Person type
	 * of object
	 */
	public void add(Person<T> value);

	/**
	 * This method has one parameter Person object is used to delete element from
	 * the container.
	 */
	public boolean remove(Person<T> value);
}
