/*
 * LinkedList2.java - Class to manage LinkedLists.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedlinkedlists1.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 *  
 * 	- append()
 *  clear()
 *  contains()
 *  occurrences()
 *  deleteHead()
 *  deleteTail()
 *  - delete()
 *  deleteFirstOccurrence()
 *  deleteLastOccurrence()
 *  deleteAllOccurrences()
 *  fromArray()
 *  getPosition()
 *  insert()
 *  isEmpty()
 *  - length()
 *  pop()
 *  - prepend()
 *  - printList()
 *  search()
 *  toArray()
 *  
 */

public class LinkedList2 
{

	Node head;
	
	// Append data to the end of the
	// list. In order to do this we
	// must walk the list to the end
	// following the pointers from one
	// element to the next.
	public void append(int data)
	{
		// If list is empty initialize
		// head with new Node
		if (head == null)
		{
			head = new Node(data);
			return;
		}
		// Establish pointer based on
		// Node object reference of 
		// the head of the list
		Node current = head;
		// Walk through the linked 
		// list until we get to the 
		// end of the list
		while (current.next != null)
		{
			// Continue walking
			current = current.next;
		}
		// Now that we're at the end
		// of the list, creat new Node
		// to contain the param data
		current.next = new Node(data);
	}
	
	public void deleteWithValue(int data)
	{
		
		// Method 1 ----------------------------
		Node current = head;
		Node previous = null;
		// If the head node contains the data value
		// delete the head and reset to head to
		// the next node
		if (head != null && current.data == data)
		{
			head = current.next;
			return;
		}
		// Otherwise, 
		while (current != null && current.data != data)
		{
			previous = current;
			current = current.next;
		}
		if (current == null)
		{
			return;
		}
		previous.next = current.next;

		/*
		// Method 2 ----------------------------
		// If list is empty, nothing to do
		if (head == null) return;
		// If data is in the head, cut off
		// the head (delete it and leave it 
		// for garbage collection
		if (head.data == data)
		{
			head = head.next;
			return;
		}
		// Otherwise, walk through the list 
		// starting at the head
		Node current = head;
		while (current != null && current.data != data)
		{
			// If the next node is the tail
			// set the current reference
			// to null, which will drop
			// (delete) the tail node
			// and set current to the tail.
			if (current.next.next == null)
			{
				current.next = null;
				return;
			}
			// When (if) we see the data
			// we're looking for in the 
			// next node, set the pointer
			// to the next next value
			if (current.next.data == data)
			{
				current.next = current.next.next;
				return;
			}
			// Continue walking
			current = current.next;
		}
		*/
	}

	public int length()
	{
		// Declare & initialize counter variable
		int len = 0;
		Node current = head;
		// Walk through the LL starting
		// at the head
		while (current != null)
		{
			// Increment counter...
			len++;
			// ...until tail is found
			current = current.next;
		}
		// Return the length
		return len;
	}

	
	// Prepend data value to the
	// beginning of the list.
	public void prepend(int data)
	{
		// Create a new head Node
		Node newHead = new Node(data);
		// Change the pointer for the
		// existing head to the new head
		newHead.next = head;
		// Change head pointer to the
		// new head node
		head = newHead;
	}
	
	public void printList()
	{
		Node current = head;
		System.out.print("\nList:\n\n");
		while (current != null)
		{
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}

}
