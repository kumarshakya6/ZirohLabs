package org.pattern.pipeline;

import java.util.ArrayList;
import java.util.List;

public class StrModifier {
	List<IModify> container = new ArrayList<>();

	public void add(IModify e) {
		container.add(e);
	}

	public void remove(IModify e) {
		container.add(e);
	}

	public String processToModify(String s) {
		String v = s;
		for (IModify e : container) {
			v = e.modify(v);
		}
		return v;
	}
}
