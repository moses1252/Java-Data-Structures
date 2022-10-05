package data_structures;

import java.util.Stack;

//two stacks created in queue
public class QueueUsingStacks {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public void push(Stack<Integer> top, int data) {
		//push the data onto the stack
		top.push(data);
	}
	
	public int pop(Stack<Integer> top) {
		//if stack is empty then prompt error
		if(top.isEmpty()) {
			System.out.println("Stack Underflow");
			System.exit(0);
		}
		return top.pop();
	}
	
	public void enQueue(QueueUsingStacks q, int data) {
		push(q.s1, data);
	}
	
	public int deQueue(QueueUsingStacks q) {
		int data;
		
		//if both stacks are empty then prompt error
		if(q.s1.isEmpty() && q.s2.isEmpty()) {
			System.out.println("Q is empty");
			System.exit(0);
		}
		
		//move elements from s1 to s2 if s2 is empty
		if(q.s2.isEmpty()) {
			while(!q.s1.isEmpty()) {
				data = pop(q.s1);
				push(q.s2, data);
			}
		}
		
		data = pop(q.s2);
		return data;
	}
	
//	@Override
//	public String toString() {
//		String result = "";
//		if(!s1.isEmpty()) {
//			for(int i = 0; i < s1.size(); i++) {
//				result += s1.get(i) + " ";
//			}
//		} else {
//			int s2Size = s2.size();
//			for(int i = s2Size; i > 0; i--) {
//				result += s2.get(i - 1) + " ";
//			}
////			for(int i = 0; i < s2.size(); i++) {
////				result += s2.get(i) + " ";
////			}
//			
//		}
//		return result;
//	}
}

//Correct way, but less effiecient -----------------------------------------
//Stack<Integer> s1 = new Stack<Integer>();
//Stack<Integer> s2 = new Stack<Integer>();
//
//public void enQueue(int x) {
//	//move all elements from s1 to s2
//	while(!s1.isEmpty()) {
//		s2.push(s1.pop());
//	}
//	
//	//push item into s1
//	s1.push(x);
//	
//	//push everything back to s1
//	while(!s2.isEmpty()) {
//		s1.push(s2.pop());
//	}
//}
//
//public int deQueue() {
//	//if first stack is empty
//	if(s1.isEmpty()) {
//		System.out.println("Q is Empty");
//		System.exit(0);
//	}
//	
//	//return top of s1
//	int x = s1.peek();
//	s1.pop();
//	return x;
//}
//
//@Override
//public String toString() {
//	String result = "";
//	if(!s1.isEmpty()) {
//		for(int i = 0; i < s1.size(); i++) {
//			result += s1.get(i) + " ";
//		}
//	} else {
//		for(int i = 0; i < s1.size(); i++) {
//			result += s2.get(i) + " ";
//		}
//	}
//
//	return result;
//}



//Incorrect way: tried using my own stack class----------------------
//public class QueueUsingStacks {	
//	QueueStack que;
//	
//	//push item to stack
//	public static void push(StackUsingArrays q, int x) {
//		q.push(x);
//	}
//	
//	//pop item from stack
//	public static int pop(StackUsingArrays top) {
//		if (top.isEmpty()) {
//			System.out.println("Stack Underflow");
//			System.exit(0);
//		}
//		return top.pop();
//	}
//	
//	//enqueue an item into queue
//	public void enQueue(int x) {
//		que.stack1.push(x); 
//		//push(que.stack1, x);
//	}
//	
//	//dequeue item from queue
//	public void deQueue() {
//		int x;
//		
//		//if both stack are empty then prompt error
//		if(que.stack1.isEmpty() && que.stack2.isEmpty()) {
//			System.out.println("Queue is empty");
//			System.exit(0);
//		}
//		
//		//move elements from stack1 to stack2 if stack2 is empty
//		if(que.stack2.isEmpty()) {
//			while(!que.stack1.isEmpty()) {
//				//x = pop(que.stack1);
//				x = que.stack1.pop();
//				//push(que.stack2, x);
//				que.stack2.push(x);
//			}
//		}
//		//pop(que.stack2);
//		//que.stack2.pop();
////		x = pop(que.stack2);
////		return x;
//	}
//	
//	//print Queue
//	public void printQue() {
//		if(que.stack2.isEmpty()) {
//			System.out.println("Queue is empty");
//		} else {
//			que.stack2.printStack();
//		}
//	}
//
//
//}