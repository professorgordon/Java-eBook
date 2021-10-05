/**
 * StackJavaAPIDemo.java - Demonstrates a stack using the
 * 						   Java API Stack class.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedstacks.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.

 * @author @professorgordon
 */

import java.util.Stack;

public class StackJavaAPIDemo 
{

	public static void main(String[] args) 
	{

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(54);
		stack.push(48);
		stack.push(92);
		System.out.print("\nStack: ");
		System.out.println(stack);
		System.out.println("  Stack Size: " + stack.size());
		System.out.println("  Top of Stack: " + stack.peek());
		System.out.println("  Popped: " + stack.pop());
		
		stack.push(28);
		System.out.print("\nStack: ");
		System.out.println(stack);
		System.out.println("  Stack Size: " + stack.size());
		System.out.println("  Popped: " + stack.pop());
		
		System.out.print("\nStack: ");
		System.out.println(stack);
		System.out.println("  Stack Size: " + stack.size());
		
	}

}
