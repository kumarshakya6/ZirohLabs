package org.pattern.pipeline;

public class DemoMain {

	public static void main(String[] args) {
		StrModifier sm = new StrModifier();
		sm.add(new A());
		sm.add(new B());
		sm.add(new C());

		String out = sm.processToModify("Hello");
		System.out.println(out);
	}
}
