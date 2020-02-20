package oops.assignment;

class Pipeline {

	IOperator pipe;

	Pipeline(IOperator pipe) {
		this.pipe = pipe;
	}

	void excute(int... a) {
		pipe.checkNumber(a);
	}
}
