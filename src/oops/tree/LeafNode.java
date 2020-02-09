/**
 * 
 */
package oops.tree;

/**
 * @author vicky
 *
 */
public class LeafNode extends Node {

	LeafNode parent;

	public LeafNode(int data) {
		super(data);
		parent = null;
	}

}
