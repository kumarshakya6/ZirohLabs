package oops.tree;

public class EmptyTreeException extends Exception {
	// It serialVersionUID is optional. If is not declare. it will giving warning
	static final long serialVersionUID = 1L;

	//
	public EmptyTreeException(String s) {
		// Calling Exception class contractor
		super(s);
	}

}
