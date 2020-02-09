package oops.pen;

public class BallPen extends Pen {

	public BallPen(String colorOfInk, int quantityOfInk, String typeOfInk)
			throws InvalidColorException, InvalidQuantityException {
		super(colorOfInk, quantityOfInk);
		ink.typeOfInk = typeOfInk;

	}

	// This is the inner class of BallPen class
	class Ink {
		private String typeOfInk;
	}

	Ink ink = new Ink();

	// @override
	void refill() {
		System.out.println("this pen  can not  be refilled");
	}

	// @override
	void write() {
		System.out.println("It writes " + ink.typeOfInk + " " + this.getColorOfInk());
	}

}
