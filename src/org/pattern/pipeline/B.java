package org.pattern.pipeline;

public class B implements IModify {

	@Override
	public String modify(String s) {
		return s + " are you";
	}

}
