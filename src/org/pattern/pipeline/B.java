package org.pattern.pipeline;

public class B implements IModify {

	IModify successor;

	public void setSuccessor(IModify successor) {
		this.successor = successor;
	}

	@Override
	public String modify(String s) {

		s = s.concat(" are you");
		if (successor != null) {
			return successor.modify(s);
		} else {
			return s;
		}
	}

}
