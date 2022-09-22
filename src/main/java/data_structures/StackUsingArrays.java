package data_structures;

public class StackUsingArrays {
	//set size of array, the top of stack, and array itself
	private final int MAX = 1000;
	int top;
	int a[] = new int[MAX];
	
	//return if list is empty
	public boolean isEmpty() {
		return (top < 0);
	}
	
	public StackUsingArrays() {
		top = -1;
	}
	
	public boolean push(int x) {
		//if top is greater than max send stack overflow error, else add value to array
		if (top >= (MAX -1)) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = x;
			return true;
		}
	}
	
	//remove top element from stack
	public int pop() {
		//if top is empty send Stack Underflow error, else remove 
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int value = a[top--];
			return value;
		}
	}
	
	public int top() {
		return a[top];
	}
	
	public int size() {
		return top;
	}
	
	public void printStack() {
		for(int i = top; i > -1; i--) {
			System.out.print(a[i] + " ");
		}
	}
}
