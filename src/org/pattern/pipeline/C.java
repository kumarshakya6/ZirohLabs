package org.pattern.pipeline;

public class C implements IModify {

	@Override
	public String modify(String s) {
		return s + "?";
	}

}
