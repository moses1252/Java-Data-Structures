package main;
import data_structures.BinaryTree;
import data_structures.DoublyLinkedList;
import data_structures.QueueUsingStacks;
import data_structures.SinglyLinkedList;
import data_structures.StackUsingArrays;
import data_structures.StackUsingLinkedList;

public class Main {

	public static void main(String[] args) {
		//Uncomment testing methods calls to see results
		//singly linked list
		SinglyLinkedList list1 = new SinglyLinkedList();
		//method testing linked list
		//testSinglyLinkedList(list1);
		
		DoublyLinkedList list2 = new DoublyLinkedList();
		//method testing linked list
		//testDoublyLinkedList(list2);
		
		StackUsingArrays list3 = new StackUsingArrays();
		//method testing stack
		//testStackUsingArrays(list3);
		
		StackUsingLinkedList list4 = new StackUsingLinkedList();
		//method testing stack
		//testStackUsingLinkedList(list4);
		
		QueueUsingStacks list5 = new QueueUsingStacks();
		//method testing queue
		//testQueueUsingStacks(list5);
		

		BinaryTree list6 = new BinaryTree();
		//method testing queue
		testBinaryTree(list6);
	}
	
	static void testSinglyLinkedList(SinglyLinkedList list) {
		//enter data into the end of list
		System.out.print("Add three values at the end of the list.");
		list.insertLast(3);
		list.insertLast(5);
		list.insertLast(9);
		list.printList();

		//enter data into the beginning of list
		System.out.print("\n\nAdd two values at the beggining of the list.");
		list.insertFirst(15);
		list.insertFirst(10);
		list.printList();
		
		//add data at the 3rd index
		System.out.print("\n\nAdd the value 19 at the 4th index");
		list.insertAtIndex(19, 3);
		list.printList();
		
		//delete first value
		System.out.print("\n\nDelete the first Value");
		list.deleteFirst();
		list.printList();
		
		//delete last value
		System.out.print("\n\nDelete the last Value");
		list.deleteLast();
		list.printList();
		
		//delete key value
		System.out.print("\n\nDelete the value 19 from the list");
		list.deleteByKey(19);
		list.printList();
		
		//delete value by index
		System.out.print("\n\nDelete the 1st index in the list");
		list.deleteByIndex(1);
		list.printList();
	}
	
	static void testDoublyLinkedList(DoublyLinkedList list) {
		//enter data into the end of list
		System.out.println("Add three values at the end of the list.");

		list.insertLast(3);
		list.insertLast(5);
		list.insertLast(9);
		list.printList();
		
		//enter data into the end of list
		System.out.print("\n\nAdd three values at the beggining of the list.");
		list.insertFirst(2);
		list.insertFirst(7);
		list.insertFirst(10);
		list.printList();
		
		
		//add data at the 3rd index
		System.out.print("\n\nAdd the value 19 at the 4th index");
		list.insertAtIndex(19, 3);
		list.printList();
		
		//delete first value
		System.out.print("\n\nDelete the first Value");
		list.deleteFirst();
		list.printList();
		
		//delete last value
		System.out.print("\n\nDelete the last Value");
		list.deleteLast();
		list.printList();
		
		//delete by key
		System.out.print("\n\nDelete the value 3 from the list");
		list.deleteByKey(3);
		list.printList();
		
		//delete value by index
		System.out.print("\n\nDelete the 1st index in the list");
		list.deleteByIndex(2);
		list.printList();
	}
	
	static void testStackUsingArrays(StackUsingArrays list) {
		//enter data into the list
		System.out.println("Add values to the list");
		list.push(2);
		list.push(4);
		list.push(8);
		list.push(13);
		list.push(202);
		list.printStack();
		
		//remove data from the list
		System.out.println("\n\nRemove values from the list");
		list.pop();
		list.pop();
		list.printStack();
		
		//check if array is empty
		System.out.println("\n\nCheck if list empty");
		System.out.println(list.isEmpty());
		
		//return top value
		System.out.println("\nReturn stack top value");
		System.out.print(list.top());
		
		//count stack size
		System.out.println("\n\nReturn stack size");
		System.out.println(list.size());
		
		//print stack
		System.out.print("\nList: ");
		list.printStack();
	}
	
	static void  testStackUsingLinkedList(StackUsingLinkedList list) {
		//enter data into the list
		System.out.println("Add values to the list");
		list.push(2);
		list.push(4);
		list.push(8);
		list.push(13);
		list.push(202);
		list.printStack();
		
		//remove data from the list
		System.out.println("\n\nRemove values from the list");
		list.pop();
		list.pop();
		
		//check if array is empty
		System.out.println("\n\nCheck if list empty");
		System.out.println(list.isEmpty());
		
		//return top value
		System.out.println("\nReturn stack top value");
		System.out.print(list.top());
		
		//count stack size
		System.out.println("\n\nReturn stack size");
		System.out.println(list.size());
		
		//print stack
		System.out.print("\nList: ");
		list.printStack();
	}
	
	static void testQueueUsingStacks(QueueUsingStacks list) {
		//add data into queue
		list.enQueue(list, 1);
		list.enQueue(list, 2);
		list.enQueue(list, 3);
		
        // Dequeue items and print
        System.out.print(list.deQueue(list) + " ");
        System.out.print(list.deQueue(list) + " ");
        System.out.println(list.deQueue(list) + " ");
	}
	
	static void testBinaryTree(BinaryTree bt) {
		//add data into tree
		System.out.println("Add values to binary search tree: ");
		for(int i = 1; i < 7; i++) {
			bt.add(i);
			System.out.print(i + " ");
		}

		//print height and diameter
        System.out.println("\nHeight of tree " + bt.height(bt.getRoot()));
        System.out.println("Diameter of tree " + bt.diameter());

        //add more values into tree and check if diameter changes
		System.out.println("\nAdd more values to binary search tree to test diameter: ");
	  	for(int i = -1; i > -6; i--) {
				bt.add(i);
				System.out.print(i + " ");
		}
        System.out.println("Height of tree " + bt.height(bt.getRoot()));
        System.out.println("Diameter of tree " + bt.diameter());
        
        //find a value in the tree
        //try finding a value thats not in the tree
        System.out.print("\nIs the value 8 in the tree: " + bt.containsBinaryNode(6));
        System.out.print("\nIs the value 15 in the tree: " + bt.containsBinaryNode(15));
        
        //delete the value 6 from the list
        System.out.println("\nDelete the value -6 from the tree");
        bt.delete(-6);

        //traverse tree in in-order
        System.out.print("\nPrint Tree: in-order traversal: ");
        bt.traverseInOrder(bt.getRoot());
        
        //traverse tree in post-order
        System.out.print("\nPrint Tree: pre-order traversal: ");
        bt.traversePreOrder(bt.getRoot());
        
        //traverse tree in post-order
        System.out.print("\nPrint Tree: post-order traversal: ");
        bt.traversePostOrder(bt.getRoot());
        
        //traverse tree in post-order
        System.out.print("\nPrint Tree: level-order traversal: ");
        bt.traverseLevelOrder();
	
        
      //traverse tree in post-order
        System.out.print("\n\nprint tree: \n\n");
        bt.printBinaryTree(bt.getRoot());
	}

}
