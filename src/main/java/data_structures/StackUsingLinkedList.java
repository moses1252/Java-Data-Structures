package data_structures;

public class StackUsingLinkedList {
	StackNode root;
	
	class StackNode {
		int data;
		StackNode next;
		
		StackNode() {
			
		}
		
		StackNode(int data) {
			this.data = data;
			next = null;
		}
	}
	
	//isEmpty
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//push
	public void push(int data) {	
		//set data and traverse through linked list
		StackNode newNode = new StackNode(data);
		
		//if root is empty add data to it
		if (isEmpty()) {
			root = newNode;
		} else {
			StackNode tempNode = root;
			root = newNode;
			newNode.next = tempNode;
		}
		System.out.println(data + " pushed to stack");

	}
	
	//pop
	public int pop() {
		int popped = Integer.MIN_VALUE;
		//if root is empty add data to it
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			popped = root.data;
			root = root.next;
		}
		return popped;
	}
	
	//top
	public int top() {
		//if root is empty add data to it
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		} else {
			return root.data;
		}
	}
	
	//size
	public int size() {
		//if root is empty add data to it
		if (isEmpty()) {
			return 0;
		}
		
		//set data and traverse through linked list
		StackNode currNode = root;
		int count = 0;
		
		if(currNode.next == null) {
			return 1;
		}
		
		while(currNode.next != null) {
			count++;
			currNode = currNode.next;
		}
		return count;
	}
	
	//print stack
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
		} 
		StackNode currNode = root;
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
}
