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
		NodeD newNode = new NodeD(data);
		
		//set head to new node
		//make the new node as head and previous as NULL
		newNode.next = head;
		newNode.prev = null;
		
		//if the head wasn't null, then add newNode had head preview
		if (head != null) {
			head.prev = newNode;
		}
		//last step, set head node as newNode
		head = newNode;
	}
	
	//insert a new node at end of list
	public void insertLast(int data) {
		NodeD newNode = new NodeD(data);
		NodeD currNode = head;
		newNode.next = null;
		
		//if the list is empty then set data has head
		if(head == null) {
			newNode.prev = null;
			head = newNode;
			return;
		}

		//traverse to the end
		while(currNode.next != null) {
			currNode = currNode.next;
		}
		
		//add node to the end
		currNode.next = newNode;
		newNode.prev = currNode;
	}
	
	public void insertAtIndex(int data, int index) {
		//if index is invalid print error
		if(index <= 0) {
			System.out.println("\nError: Invalid index");
			return;
		}
		
		//if the index is zero add node to the beginning
		if (index == 0) {
			insertFirst(data);
		}
		
		
		//traverse the list while counting to add node at specific index
		int count = 0;
		NodeD currNode = head;
		while(currNode != null) {
			//once index is reached add node
			if(count == index) {
				NodeD newNode = new NodeD(data);
				newNode.next = currNode.next;
				currNode.next = newNode;
				newNode.prev = currNode;
				break;
			} else { //else keep traversing
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
		
		//traverse to the end of list
		while(currNode.next != null) {
			prev = currNode;
			currNode = currNode.next;
		}
		//remove last node from list
		prev.next = null;
	}
	
	//delete node by key
	public void deleteByKey(int key) {
		//check if head holds the key
		if(head.data == key) {
			deleteFirst();
		}


		//traverse through list until we find key
		NodeD currNode = head, prev = null;
		while(currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		
		//if currNode isn't null add node
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
		
		//traverse through list until index is reached
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
		
		//if currNode is null return error
		if (currNode == null) {
			System.out.print("\nError: Index is out of bounds");
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
