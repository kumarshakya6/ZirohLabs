/**
 * 
 */
package oops.assignment;

/**
 * @author vicky
 *
 */
public class LeafNode extends Node {

	Node parent;

	public LeafNode(int key, IOperator pipe) {
		super(key, pipe);
		parent = null;
	}

}
