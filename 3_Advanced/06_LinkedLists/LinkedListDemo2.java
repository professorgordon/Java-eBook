/*
 * LinkedListDemo2.java - Program to demonstrate use of the
 *                        LinkedList and Node classes.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedlinkedlists1.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */
import java.util.Random;
public class LinkedListDemo2
{

	public static void main(String[] args)

	{
		int min = 10;
		int max = 99;
		int numNodes = 800;
		Random rand = new Random();
		LinkedList2 ll = new LinkedList2();

		for (int i = 1; i <= numNodes; i++ )
		{
			ll.append(rand.nextInt((max - min) + 1) + min);;
		}
		
		//ll.deleteWithValue(10);

		ll.printList();
		System.out.println("\nList Length: " + ll.length());
	}
	
}



