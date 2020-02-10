package org.datastructure.tree;

public class RadixNode {
	RadixNode left, right;
	boolean flag;
	String data;

	RadixNode(String data) {
		this.data = data;
		flag = false;
		left = right = null;
	}

	public RadixNode getLeft() {
		return left;
	}

	public void setLeft(RadixNode left) {
		this.left = left;
	}

	public RadixNode getRight() {
		return right;
	}

	public void setRight(RadixNode right) {
		this.right = right;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
