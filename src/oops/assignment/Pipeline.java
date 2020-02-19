package oops.assignment;

public class Pipeline {

	IOperator pipe;

	public Pipeline(IOperator pipe) {
		this.pipe = pipe;
	}

	public void excute(int... a) {
		pipe.checkNumber(a);
	}
}
