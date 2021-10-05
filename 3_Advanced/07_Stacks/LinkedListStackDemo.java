/*
 * LinkedListStackDemo.java - Demo of a stack using the
 * 						  	  non-API linked list data structure.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedstacks.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class LinkedListStackDemo 
{

	public static void main(String[] args) 
	{

		LinkedListStack lls=new LinkedListStack();
		
		lls.push(54);
		lls.push(48);
		lls.push(92);
		lls.printStack(lls.head);
		System.out.println("  Stack Size: " + lls.size());
		System.out.println("  Top of Stack: " + lls.peek());
		System.out.println("  Popped: " + lls.pop());
		lls.push(28);
		lls.printStack(lls.head);
		System.out.println("  Stack Size: " + lls.size());
		System.out.println("  Popped: " + lls.pop());
		lls.printStack(lls.head);
		System.out.println("  Stack Size: " + lls.size());

	}

}
