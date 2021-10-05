/*
 * LinkedListStack.java - Implementation of a stack using 
 * 						  the linked list data structure.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedstacks.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 * Methods:
 * 		LinkedListStack() - Constructor
 * 		push(int data)
 * 		pop() - Returns value of top node and removes node
 * 		peek() - Returns top node value w/o removing node
 * 		size() - Returns number of nodes in the stack
 * 		isEmpty() - Returns whether stack is empty or not.
 * 		printStack(LinkedListStack head)
 */

public class LinkedListStack 
{
	Node head;
	 
	public LinkedListStack() 
	{
		head = null;
	}
 
	public void push(int data) 
	{
		Node oldHead = head;
		head = new Node(data);
		head.next = oldHead;
	}
 
	public int pop()
	{
		if (head == null) 
		{
			return -1;
		}
		else
		{
			int value = head.data;
			head = head.next;
			return value;
		}
	}
 
	public int peek()
	{
		if (!isEmpty()) 
		{ 
			return head.data; 
		} 
		else
		{ 
			System.out.println("Stack is empty"); 
			return -1; 
		} 
	}
	
	public int size()
	{
		Node temp = head;
		int nodeCount = 0;
		while (temp != null)
		{
			temp = temp.next;
			nodeCount++;
		}
		return nodeCount;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}

	public void printStack(Node head) 
	{
		Node temp = head;
		System.out.print("\nStack: ");
		while (temp != null) 
		{
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

}
