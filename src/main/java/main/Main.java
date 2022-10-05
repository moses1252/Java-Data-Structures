package main;

import data_structures.BinaryNode;
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
		//method testing binary tree
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
		
		list.enQueue(list, 1);
		list.enQueue(list, 2);
		list.enQueue(list, 3);
		
        // Dequeue items
        System.out.print(list.deQueue(list) + " ");
        System.out.print(list.deQueue(list) + " ");
        System.out.println(list.deQueue(list) + " ");
	}
	
	static void testBinaryTree(BinaryTree tree) {
		  
        // create root
		tree.setRoot(new BinaryNode(1));
        //tree.setRoot(new binaryNode(1));
  
        /* following is the tree after above statement
  
              1
            /   \
          null  null     */
  
        tree.getRoot().left =new BinaryNode(2);
        tree.getRoot().right = new BinaryNode(3);
  
        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
  
        tree.getRoot().left.left = new BinaryNode(4);
        tree.getRoot().left.right = new BinaryNode(5);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

        
     System.out.println("The diameter of given binary tree is : " 
     + tree.diameter());
     
     tree.getRoot().left.left.left = new BinaryNode(6);
     System.out.println("The diameter of given binary tree is : " 
     + tree.diameter());
     
     tree.getRoot().left.left.left.left = new BinaryNode(7);
     System.out.println("The diameter of given binary tree is : " 
     + tree.diameter());
	}

}
