/**
 * LinkedListQueueDemo Class - Demo of a queue using the
 *                            non-API linked list data
 *                            structure.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedqueues.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class LinkedListQueueDemo 
{

	public static void main(String[] args) 
	{

		LinkedListQueue llq = new LinkedListQueue(); 

		llq.enqueue(43); 
		llq.enqueue(82); 
		llq.printQueue(llq.front);
		System.out.println("  Queue Size: " + llq.size());
		System.out.println("  Front of Queue: " + llq.front());
		System.out.println("  Back of Queue: " + llq.back());
		llq.dequeue(); 
		llq.dequeue(); 
		llq.printQueue(llq.front);
		System.out.println("  Queue Size: " + llq.size());
		System.out.println("  Front of Queue: " + llq.front());
		System.out.println("  Back of Queue: " + llq.back());
		llq.enqueue(59); 
		llq.enqueue(11); 
		llq.enqueue(27); 
		llq.enqueue(77); 
		llq.enqueue(99); 
		llq.enqueue(31); 
		llq.printQueue(llq.front);
		System.out.println("  Queue Size: " + llq.size());
		System.out.println("  Front of Queue: " + llq.front());
		System.out.println("  Back of Queue: " + llq.back());
		llq.dequeue(); 
		llq.printQueue(llq.front);
		System.out.println("  Queue Size: " + llq.size());
		System.out.println("  Front of Queue: " + llq.front());
		System.out.println("  Back of Queue: " + llq.back());
        System.out.println("  Queue Front : " + llq.front.data); 
        System.out.println("  Queue Back : " + llq.back.data); 
	
		
	}

}
