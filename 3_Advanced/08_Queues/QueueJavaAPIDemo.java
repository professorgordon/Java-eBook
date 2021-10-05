/**
 * QueueJavaAPIDemo.java - Demonstrates a queue using the
 * 						   Java API Stack class.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedqueues.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

import java.util.Queue;
import java.util.LinkedList;

public class QueueJavaAPIDemo 
{

	public static void main(String[] args) 
	{

		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(43);
		q.add(82);
		System.out.println("\nQueue: " + q);
		System.out.println("  Queue Size: " + q.size());
		System.out.println("  Front of Queue: " + q.peek());
		q.remove();
		q.remove();
		System.out.println("\nQueue: " + q);
		System.out.println("  Queue Size: " + q.size());
		System.out.println("  Front of Queue: " + q.peek());
		q.add(59); 
		q.add(11); 
		q.add(27); 
		q.add(77); 
		q.add(99); 
		q.add(31); 
		System.out.println("\nQueue: " + q);
		System.out.println("  Queue Size: " + q.size());
		System.out.println("  Front of Queue: " + q.peek());
		q.remove();
		System.out.println("\nQueue: " + q);
		System.out.println("  Queue Size: " + q.size());
		System.out.println("  Front of Queue: " + q.peek());		

	}

}
