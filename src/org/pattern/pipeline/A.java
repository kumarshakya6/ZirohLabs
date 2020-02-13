package org.pattern.pipeline;

public class A implements IModify {

	@Override
	public String modify(String s) {

		return s + " How";
	}

}
