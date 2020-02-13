package org.pattern.strategy;

public class Letter {
	private String name;
	private Print strategy;

	Letter(String name) {
		this.name = name;
	}

	public void setStrategy(Print strategy) {
		this.strategy = strategy;
	}

	public void apply() {
		strategy.process(name);
	}
}
