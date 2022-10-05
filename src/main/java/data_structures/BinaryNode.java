package data_structures;

//each node will have left and right child
public class BinaryNode {
	int key;
	public BinaryNode left;
	public BinaryNode right;
	
	public BinaryNode(int key) {
		this.key = key;
		left = right = null;
	}	
}
