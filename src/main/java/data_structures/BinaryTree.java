package data_structures;

public class BinaryTree {
	BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int key) {
		root = new BinaryNode(key);
	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}
	
	
	   // Method to calculate the diameter and return it to
    // main
    int diameter(BinaryNode root) {
        // base case if tree is empty
        if (root == null)
            return 0;
 
        // get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);
 
        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);
 
        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right
          subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));
    }
 
    // A wrapper over diameter(BinaryNode root)
    public int diameter() {
    	return diameter(root); 
    }
 
    // The function Compute the "height" of a tree. Height
    // is the number of nodes along the longest path from
    // the root node down to the farthest leaf node.
    static int height(BinaryNode node) {
        // base case tree is empty
        if (node == null)
            return 0;
 
        // If tree is not empty then height = 1 + max of
        //  left height and right heights
        return (1
                + Math.max(height(node.left),
                           height(node.right)));
    }	
}
