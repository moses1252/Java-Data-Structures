package data_structures;

class Node {
	int data;
	Node next;
	
	Node() {

	}
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}

public class SinglyLinkedList {
	private Node head;
	
	
	//insert a new node at beginning of list
	public void insertFirst(int data) {
		//create new node for data and set its data
		Node newNode = new Node(data);
		
		//place head node as new nodes next value
		//set new node as the head node
		newNode.next = head;
		head = newNode;
	}
	
	//insert a new node at end of list
	public void insertLast(int data) {
		//if head is null then set data
		if (head == null) {
			Node newNode = new Node(data);
			head = newNode;
			return;
		}
		
		Node currNode = head;
		//traverse to the end
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		
		//create new node and add it to last node
		Node newNode = new Node(data);
		currNode.next = newNode;
	}
	
	//insert a new node at a specific index
	public void insertAtIndex(int data, int index) {
		//if index is invalid print error
		if(index <= 0) {
			System.out.println("\nError: Invalid index");
		}
		
		//if index == 0 replace head
		if(index == 0) {
			insertFirst(data);
		}
		
		int count = 0;
		Node currNode = head, prev = null;
		while(currNode != null) {
			if(count == index) {
				Node newNode = new Node(data);
				prev.next = newNode;
				newNode.next = currNode;
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				count++;
			}
		}
		
		//if currNode is null then the index is greater than the size of the list
		if (currNode == null) {
			System.out.println("\nThe index " + index + " was not found");
		}		
	}
	
	//delete node at beginning of list
	public void deleteFirst() {
		head = head.next;
	}
	
	//delete node at end of list
	public void deleteLast() {
		Node currNode = head, prev = null;
		//traverse to the end
		while(currNode.next != null) {
			prev = currNode;
			currNode = currNode.next;
		}
		//remove the value
		prev.next = null;
	}
	
	//delete by key
	public void deleteByKey(int key) {
		//check if head node holds key
		if(head != null && head.data == key) {
			head = head.next;
		}
		
		Node currNode = head, prev = null;
		//search for key in list
		while(currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		
		//if key was present, currNode holds it value
		if(currNode != null) {
			prev.next = currNode.next;
		} else {
			System.out.println("\n" + key + " not found");
		}
	}
	
	
	//delete by index
	public void deleteByIndex(int index) {
		//if index is 0 replace head
		if(head != null & index == 0 ) {
			head = head.next;
		}
		
		Node currNode = head, prev = null;
		int count = 0;
		while(currNode != null) {
			if (count == index) {
				prev.next = currNode.next;
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				count++;
			}
		}
		if(currNode == null) {
			System.out.println("\nThe index " + index + " was not found");
		}
	}
	// print list
	public void printList() {
		Node currNode = head;
		System.out.print("\nLinked List: ");
		
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
}
