package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

	List<T> q = new ArrayList<>();

	public void add(T data) {
		q.add(data);
	}

	public T remove() throws EmptyQueueException {
		if (!q.isEmpty())
			return q.remove(0);

		throw new EmptyQueueException("Queue is empty");
	}

	public int getSize() {
		return q.size();
	}

	public boolean isEmpty() {
		return q.isEmpty();
	}

	public boolean contains(T data) {
		return q.contains(data);
	}

}
