/**
 * 
 */
package oops.notebook;

/**
 * @author vicky
 *
 */
public interface Book {

	final int totalPages = 100000;

	public void write();

	public boolean isEmpty();

	public String read(int pageNumber);

}
