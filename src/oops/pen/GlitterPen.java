package oops.pen;

public class GlitterPen extends Pen {
	class Ink {
		private String typeOfInk;

	}

	Ink ink = new Ink();

	// create contractor of GlitterPen class with 3 parameters with in this
	// contractor
	// color that is String type
	// quantity this is also a String type
	// typeOfInk this is also a String type
	public GlitterPen(String colorOfInk, int quantityOfInk, String typeOfInk)
			throws InvalidColorException, InvalidQuantityException {
		super(colorOfInk, quantityOfInk);
		ink.typeOfInk = typeOfInk;

	}

	// @override
	void refill(int quantityOfInk) {
//		System.out.println("This pen can be refill");
		this.setQuantityOfInk(quantityOfInk);

	}

	// @override
	void write() {
		System.out.println("It writes " + ink.typeOfInk + " " + this.getColorOfInk());
	}

}
