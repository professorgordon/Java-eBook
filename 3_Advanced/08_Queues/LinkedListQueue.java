/**
 * LinkedListQueue Class - Queue implementation using a 
 * 		                   LinkedList coded from scratch, 
 *                         rather than using the Java API 
 *                         classes.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedqueues.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 * Methods:	LinkedListQueue() - Constructor
 * 			enqueue(int data) - Adds a new node to the 
 *                              back of the queue
 * 			dequeue() - Removes the front node and resets the 
 *                      front pointer to the next node
 * 			front() - Returns front node value w/o removing node
 * 			back() - Returns back node value w/o removing node
 * 			size() - Returns number of nodes in the queue
 * 			isEmpty() - Returns whether queue is empty or not.
 * 			printQueue(LinkedListQueue head)
 */
public class LinkedListQueue 
{
	
	Node front, back;
	 
	public LinkedListQueue() 
	{
		front = back = null;
	}
 
	public void enqueue(int data)
	{
		Node temp = new Node(data);
		if (this.back == null)
		{
			this.front = this.back = temp;
			return;
		}
		this.back.next = temp;
		this.back = temp;
	}
	
	public void dequeue()
	{
		if (this.front == null) return;
		this.front = this.front.next;
		if (this.front == null) this.back = null;
	}

	public int front()
	{
		if (!isEmpty()) 
		{ 
			return front.data; 
		} 
		else
		{ 
			System.out.println("  Queue is empty"); 
			return -1; 
		} 
	}

	public int back()
	{
		if (!isEmpty()) 
		{ 
			return back.data; 
		} 
		else
		{ 
			System.out.println("  Queue is empty"); 
			return -1; 
		} 
	}

	public int size()
	{
		Node temp = front;
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
		return front == null;
	}

	public void printQueue(Node front) 
	{
		Node temp = front;
		System.out.print("\nQueue: ");
		while (temp != null) 
		{
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
}
