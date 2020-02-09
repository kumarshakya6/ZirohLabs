/**
 * 
 */
package oops.notebook;

/**
 * @author vicky
 *
 */
public class NoteBook {
	final private int totalPages;
	private int writtenPages;
	private int blankPages;

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * @return the writtenPages
	 */
	public int getWrittenPages() {
		return writtenPages;
	}

	/**
	 * @return the blackPages
	 */
	public int getBlankPages() {
		return blankPages;
	}

	NoteBook(int totalPages) {
		this.totalPages = totalPages;
		this.blankPages = totalPages;
		this.writtenPages = 0;
	}

	public void write(int pages) {

		while (isEmpty() && pages-- > 0) {
			blankPages--;
			writtenPages++;
		}
		if (pages > 0) {
			System.out.println("This book is is over flow." + "remaining contents is " + pages);
		} else {
			System.out.println("Pages have written.");
		}

	}

	public boolean isEmpty() {
		if (blankPages > 0) {
			return true;
		} else {
			return false;
		}
	}
}
