package org.pattern.pipeline;

public class Pipeline {

	IModify pipe;

	public Pipeline(IModify pipe) {
		this.pipe = pipe;

	}

	public String excute(String value) {
		return pipe.modify(value);
	}
}
