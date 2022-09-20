package data_structures;


class NodeD {
	int data;
	NodeD next;
	NodeD prev;
	
	NodeD() {
		
	}
	
	NodeD(int data) {
		this.data = data;
		next = null;
		prev = null;
	}
}

public class DoublyLinkedList {
	NodeD head;
	
	//insert a new node at beginning of list
	public void insertFirst(int data) {
		//set head to new node
		NodeD newNode = new NodeD(data);
		
		//make next of new node as head and previous as NULL
		newNode.next = head;
		newNode.prev = null;
		
		if (head != null) {
			head.prev = newNode;
		}
		head = newNode;
	}
	
	//insert a new node at beginning of list
	public void insertLast(int data) {
		NodeD newNode = new NodeD(data);
		NodeD currNode = head;
		newNode.next = null;
		
		if(head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}

		while(currNode.next != null) {
			currNode = currNode.next;
		}
		
		currNode.next = newNode;
		newNode.prev = currNode;
	}
	
	public void insertAtIndex(int data, int index) {
		//if index is invalid print error
		if(index <= 0) {
			System.out.println("\nError: Invalid index");
			return;
		}
		
		if (index == 0) {
			insertFirst(data);
		}
//		NodeD newNode = new NodeD(data);
//		//if index is 0 add to head
//		if(index == 0) {
//			newNode.prev = null;
//			head = newNode;
//			return;
//		}
		
		
		int count = 0;
		NodeD currNode = head;
		while(currNode != null) {
			if(count == index) {
				NodeD newNode = new NodeD(data);
				newNode.next = currNode.next;
				currNode.next = newNode;
				newNode.prev = currNode;
				break;

			} else {
				currNode = currNode.next;
				count++;
			}
		}
		
		//if currNode is null then the index is greater than the size of the list
		if (currNode == null) {
			System.out.println("\nThe index " + index + " was not found");
		}	
	}
	
	//delete first node
	public void deleteFirst() {
		head = head.next;
		head.prev = null;
	}
	
	//delete last node
	public void deleteLast() {
		NodeD currNode = head, prev = null;
		
		while(currNode.next != null) {
			prev = currNode;
			currNode = currNode.next;
		}
		
		prev.next = null;
	}
	
	//delete node by key
	public void deleteByKey(int key) {
		//check if head holds the key
		if(head.data == key) {
			deleteFirst();
		}

		NodeD currNode = head, prev = null;
		while(currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		
		if(currNode != null) {
			prev.next = currNode.next;
			currNode.next.prev = prev;
		} else {
			System.out.println("\n" + key + " not found");
		}
	}
	
	//delete node by key
	public void deleteByIndex(int index) {
		//check if index is equal to zero
		if(index == 0) {
			deleteFirst();
		}
		
		int count = 0;
		NodeD currNode = head, prev = null;
		while(currNode != null) {
			if (index == count) {
				prev.next = currNode.next;
				currNode.next.prev = prev;
				break;
			} else {
				prev = currNode;
				currNode = currNode.next;
				count++;
			}
		}
		
		if (currNode == null) {
			System.out.print("\nError: index is out of bounds");
		}
	}
	
	// print list
	public void printList() {
		NodeD currNode = head;
		System.out.print("\nLinked List: ");
		
		while(currNode != null) {
			System.out.print(currNode.data + " ");
			currNode = currNode.next;
		}
	}
	

}
