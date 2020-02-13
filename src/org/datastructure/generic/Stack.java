/**
 * 
 */
package org.datastructure.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vicky
 *
 */
public class Stack<T> {
	private int top = -1;

	List<T> s = new ArrayList<T>();

	public void push(T data) throws StackOverFlowException {
		pushPrivate(data);

	}

	private void pushPrivate(T data) throws StackOverFlowException {
		if (top >= Integer.MAX_VALUE - 1) {
			throw new StackOverFlowException("Stack Overflow");
		} else {
			s.add(++top, data);
		}
	}

	public T pop() throws StackUnderFlowException {

		return popPrivate();

	}

	private T popPrivate() throws StackUnderFlowException {

		if (top < 0) {
			throw new StackUnderFlowException("Stack Under Flow Exception");
		} else {
			return s.remove(top--);

		}
	}

	public int getSize() {
		if (top < 0) {
			return 0;
		} else {
			return top + 1;
		}
	}

	public boolean isEmpty() {
		if (top < 0) {
			return true;
		} else {
			return false;
		}
	}

	public T getPeek() throws StackIsEmpty {
		if (!isEmpty()) {
			return s.get(top);
		}

		throw new StackIsEmpty("Stack is Empty");

	}

}
