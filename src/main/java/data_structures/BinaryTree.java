package data_structures;

import java.util.LinkedList;
import java.util.Queue;

/* Personal notes
 * How to find height of a binary tree
 * Height of a node:
 * Number of edtges in longest path from the node to a leaf node
 * 
 *Height of tree = height of root
 *Height of tree with 1 node = 0
 *Depth of a node = No. of edges
 *in path from root to that node 
 */


class BinaryNode {
	int key;
	BinaryNode left;
	BinaryNode right;
	
	public BinaryNode(int key) {
		this.key = key;
		left = right = null;
	}	
}

public class BinaryTree {
	private BinaryNode root;
	
	public BinaryTree() {
		root = null;
	}
	
	public BinaryTree(int key) {
		root = new BinaryNode(key);
	}
	
    // get diameter
    public int diameter() {
    	return diameter(root); 
    }
	
	// diameter helper method
    private int diameter(BinaryNode node) {
        // base case if tree is empty
        if (node == null) {
            return 0;
        }
 
        // get the height of left and right sub-trees
        int lheight = height(node.left);
        int rheight = height(node.right);
 


        return lheight + rheight + 1;
    }
 
    //return the highest height from left or right node
    public static int height(BinaryNode node) {
        // base case tree is empty
        if (node == null)
            return 0;
 
        // If tree is not empty then height = 1 + max of left height and right heights
        return (1 + Math.max(height(node.left), height(node.right)));
    }
    
    public void add(int key) {
    	root = addRecursive(root, key);
    }
    
    //add helper method
    private BinaryNode addRecursive(BinaryNode current, int key) {
    	if (current == null ) {
    		return new BinaryNode(key);
    	}
    	
    	if (key < current.key) {
    		current.left = addRecursive(current.left, key);
    	} else if (key > current.key) {
    		current.right = addRecursive(current.right, key);
    	} else {
    		//value already exist
    		return current;
    	}
    	
		return current;
    }
    
    //find value in tree
    public boolean containsBinaryNode(int value) {
    	return containsBinaryNodeRecursive(root, value);
    }
    
    //helper method
    private boolean containsBinaryNodeRecursive(BinaryNode current, int key) {
    	//if tree if empty return false
    	if (current == null) {
    		return false;
    	} else if (key == current.key) {
    		return true;
    	}
    	return key < current.key
    		? containsBinaryNodeRecursive(current.left, key)
    		: containsBinaryNodeRecursive(current.right, key);
    }
    
    public void delete(int key) {
    	root = deleteRecursive(root, key);
    }
    
    //delete value in binary search tree
    private BinaryNode deleteRecursive(BinaryNode current, int key) {
    	if (current == null) {
    		return null;
    	} else if (key == current.key) {
    		//Node to delete found
    		
    		
    		if (current.left == null && current.right == null) {
    			return null;
    		}
    		
    		if (current.right == null) {
    			return current.left;
    		}
    		if (current.left == null) {
    			return current.right;
    		}
    		
    		int smallestValue = findSmallestValue(current.right);
    		current.key = smallestValue;
    		current.right = deleteRecursive(current.right, smallestValue);
    		return current;
    		
    	}
    	
    	if (key < current.key) {
    		current.left = deleteRecursive(current.left, key);
    		return current;
    	}
    	
    	current.right = deleteRecursive(current.right, key);
    	return current;
    }
    
    private int findSmallestValue(BinaryNode root) {
    	return root.left == null ? root.key : findSmallestValue(root.left);
    }
    
    public void traverseInOrder(BinaryNode node) {
    	if (node != null) {
    		traverseInOrder(node.left);
    		System.out.print(node.key + " ");
    		traverseInOrder(node.right);
    	}
    }
    
    public void traversePreOrder(BinaryNode node) {
    	if (node != null) {
    		System.out.print(node.key + " ");
    		traversePreOrder(node.left);
    		traversePreOrder(node.right);
    	}
    }
    
    public void traversePostOrder(BinaryNode node) {
    	if (node != null) {
    		traversePreOrder(node.left);
    		traversePreOrder(node.right);
    		System.out.print(node.key + " ");
    	}
    }
    
    public void traverseLevelOrder() {
    	if (root == null) {
    		return;
    	}
    	
    	Queue<BinaryNode> nodes = new LinkedList();
    	nodes.add(root);
    	
    	while (!nodes.isEmpty()) {
    		BinaryNode node = nodes.remove();
    		
    		System.out.print(node.key + " ");
    		
    		if (node.left != null) {
    			nodes.add(node.left);
    		}
    		
    		if (node.right != null) {
    			nodes.add(node.right);
    		}
    	}
    	
    	
    }
    
    //get root
    public BinaryNode getRoot() {
    	return root;
    }
    
    
    public static void printBinaryTree(BinaryNode root)
    {
        LinkedList<BinaryNode> treeLevel = new LinkedList<BinaryNode>();
        treeLevel.add(root);
        LinkedList<BinaryNode> temp = new LinkedList<BinaryNode>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        // System.out.println(height);
        double numberOfElements = (Math.pow(2, (height + 1)) - 1);
        // System.out.println(numberOfElements);
        while (counter <= height) {
            BinaryNode removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
            }
            else {
                printSpace(numberOfElements / Math.pow(2, counter), removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(removed.left);
                temp.add(removed.right);
            }
 
            if (treeLevel.isEmpty()) {
                System.out.println("");
                System.out.println("");
                treeLevel = temp;
                temp = new LinkedList<BinaryNode>();
                counter++;
            }
        }
    }
    
//    public static void printBinaryTree(BinaryNode root) {
//    	LinkedList<BinaryNode> treeLevel = new LinkedList<BinaryNode>();
//    	treeLevel.add(root);
//    	LinkedList<BinaryNode> temp = new LinkedList<BinaryNode>();
//    	int count = 0;
//    	int height = heightOfTree(root);
//    	
//    	//System.out.println(height);
//    	double numberOfElements = Math.pow(2, (height + 1) - 1);
//    	System.out.println(numberOfElements);
//    	while (count <= height ) {
//    		BinaryNode removed = treeLevel.removeFirst();
//    		
//    		if (temp.isEmpty()) {
//    			printSpace(numberOfElements / Math.pow(2, count + 1), removed);
//    		} else {
//    			printSpace(numberOfElements / Math.pow(2, count), removed);
//    		}
//    		
//    		if (removed == null) {
//    			temp.add(null);
//    			temp.add(null);
//    		} else {
//    			temp.add(removed.left);
//    			temp.add(removed.right);
//    		}
//    		
//    		if (treeLevel.isEmpty()) {
//    			System.out.println("");
//    			System.out.println("");
//    			treeLevel = temp;
//    			temp = new LinkedList<BinaryNode>();
//    			count++;
//    		}
//    	}
//    }
    
    private static void printSpace(double n, BinaryNode removed) {
    	for (; n > 0; n--) {
    		System.out.print("\t");
    	}
    	if (removed == null) {
    		System.out.print(" ");
    	} else {
    		System.out.print(removed.key);
    	}
    }
    
    public static int heightOfTree(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
