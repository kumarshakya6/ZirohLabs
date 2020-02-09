package oops.pen;

public class GelPan extends Pen {
	GelPan(String colorOfInk, int quantityOfInk, String typeOfInk)
			throws InvalidColorException, InvalidQuantityException {
		super(colorOfInk, quantityOfInk);
		ink.typeOfInk = typeOfInk;

	}

	class Ink {
		private String typeOfInk;
	}

	public String getTypeOfInk() {
		return ink.typeOfInk;
	}

	public void setTypeOfInk(String typeOfInk) {
		this.ink.typeOfInk = typeOfInk;
	}

	Ink ink = new Ink();

	// @override
	void refill() {
		System.out.println("This pen can't be refill");
	}

	// @override
	void write() {
		System.out.println("It writes " + ink.typeOfInk + " " + this.getColorOfInk());
	}

}
