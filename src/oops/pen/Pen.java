package oops.pen;

//This is a class of general Pen
public class Pen {

	private Ink ink = new Ink();
	int maxQuantityOfInk = 1000;

	public String getColorOfInk() {
		return ink.getColorOfInk();
	}

	public void setColorOfInk(String colorOfInk) {
		ink.setColorOfInk(colorOfInk);
	}

	public int getQuantityOfInk() {
		return ink.getQuantityOfInk();
	}

	public void setQuantityOfInk(int quantityOfInk) {
		ink.setQuantityOfInk(quantityOfInk);
	}

	Pen(String colorOfInk, int quantityOfInk) throws InvalidColorException, InvalidQuantityException {

		if (colorOfInk == null || colorOfInk == "") {
			throw new InvalidColorException("Color is not valid.");
		} else {
			ink.setColorOfInk(colorOfInk);
		}
		if (quantityOfInk <= 0 && quantityOfInk <= maxQuantityOfInk) {
			throw new InvalidQuantityException("Quantity is not valid.");
		} else {
			ink.setQuantityOfInk(quantityOfInk);
		}
	}

	// refill method is used to again fill the refill of Pen
	// there is a parameter of n is integer type
	void refill(int n) {
		System.out.println("Ink is filled.");
		ink.setQuantityOfInk(ink.getQuantityOfInk() + n);

	}

	void refill() {

	}

	void write(int n) {
		System.out.println("It writes " + ink.getColorOfInk());
		if (ink.getQuantityOfInk() >= n) {
			ink.setQuantityOfInk(ink.getQuantityOfInk() - n);
		} else {
			System.out.println("Please refill the Pen.");
			System.out.println("Minimum quantity of refill is " + (ink.getQuantityOfInk() - n));

		}

	}
}
