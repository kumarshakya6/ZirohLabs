package oops.pen;

public class Main {

	public static void main(String[] args) {
		try {
			Pen pen1 = new Pen("Red", 10);
			pen1.write(
					"This is testing phase of the write with pen. so write method takes input  a string  and writes it");

			System.out.println("This is the remaining ink in the pen :" + pen1.getQuantityOfInk());

			// pen4.refill();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
