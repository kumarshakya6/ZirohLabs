package oops.person;

public interface Container<T> {
	public void add(Person<T> value);

	public boolean remove(Person<T> value);
}
