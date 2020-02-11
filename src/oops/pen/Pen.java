package oops.pen;

import java.util.ArrayList;
import java.util.List;

//This is a class of general Pen
public class Pen {

	private Ink ink = new Ink();
	int maxQuantityOfInk = 1000;
	List<Person> personCollection = null;

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
		personCollection = new ArrayList<>();
		personCollection.add(new Manager());
		personCollection.add(new CareTaker());
		personCollection.add(new Worker());
	}

	// refill method is used to again fill the refill of Pen
	// there is a parameter of n is integer type
	void refill(int n) {
		System.out.println("Ink is filled.");
		ink.quantityOfInk += n;

	}

	void write(String str) {
		int n = str.length();
		System.out.println("It writes " + ink.colorOfInk);
		if (ink.quantityOfInk >= n) {

			ink.quantityOfInk = ink.quantityOfInk - n;
			System.out.println(str);

		} else {
			for (int index = 0; index < ink.quantityOfInk; index++) {
				System.out.print(str.charAt(index));
			}
			ink.quantityOfInk = 0;
			System.out.println();
			for (Person p : personCollection) {
				p.notify("In pen ,There is no ink, so Please refill it.");
			}

		}

	}
}
