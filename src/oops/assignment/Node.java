/**
 * 
 */
package oops.assignment;

/**
 * @author vicky
 *
 */
class Node {

	int key;
	IOperator pipe;

	Node(int key, IOperator pipe) {
		this.key = key;
		this.pipe = pipe;

	}

	// This method converts this to Internal Node
	public Node toInternalNode() {
		return new InternalNode(this.key, this.pipe);

	}

	// This method converts this to Leaf Node
	public Node toLeafNode() {
		return new LeafNode(this.key, this.pipe);

	}

	// This method converts the this to Root Node
	public Node toRootNode() {
		return new RootNode(this.key, this.pipe);
	}

}
