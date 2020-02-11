package org.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

public class Branch {
	int sum;
	List<Integer> elements;

	public Branch(int sumOfBranch, int element) {
		this.sum = sumOfBranch;
		elements = new ArrayList<>();
		elements.add(element);

	}

}
