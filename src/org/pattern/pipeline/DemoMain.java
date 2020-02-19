package org.pattern.pipeline;

public class DemoMain {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		C c = new C();

		a.setSuccessor(b);
		b.setSuccessor(c);

		Pipeline pipe = new Pipeline(a);

		System.out.println(pipe.excute("Hello Vipin"));
	}
}
