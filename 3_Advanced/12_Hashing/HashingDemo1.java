/*
 * HashingDemo1t.java - Class to demonstrate hash tables.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedHashing.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class HashingDemo1
{
	/*
		hashArray[0] -> Barnes 
		hashArray[1] -> Andrews -> Mathison -> Jones
		hashArray[2] -> Yates   -> Carlson
	*/
	public static String[] dataArray = new String[] {"Yates","Andrews","Barnes","Mathison","Jones","Carlson"};
	public static int[] customerIDsArray = new int[] {1111, 2222, 3333, 4444, 5555, 6666};
	public static HashNode hashArray[] = new HashNode[3];

	public static void main(String[] args)
	{
		displayDataArray();
		displayHashExampleOutput();
		for (int j = 0; j < dataArray.length; j++)
		{
			appendNode(hashIt(dataArray[j]), customerIDsArray[j], dataArray[j]);
		}
		displayHashArray();
	}
	
	private static void displayHashExampleOutput() 
	{
		int asciiTotal = 0;
		for (int j = 0; j < dataArray.length; j++)
		{
			for (int k = 0; k < dataArray[j].length(); k++)
			{
				char c = dataArray[j].charAt(k);
				System.out.println(c + "  " + (int)c);
				asciiTotal = asciiTotal + (int)c;
			}
			System.out.print("asciiTotal: " + asciiTotal);
			System.out.println("\t[" + asciiTotal % hashArray.length + "]\n");
			asciiTotal = 0;
		}
	}

	private static void displayDataArray() 
	{
		for (int i = 0; i < dataArray.length; i++)
		{
			System.out.printf("dataArray[%d]: %s%n", i, dataArray[i]);
		}
		System.out.println();
		for (int i = 0; i < customerIDsArray.length; i++)
		{
			System.out.printf("customerIDsArray[%d]: %s%n", i, customerIDsArray[i]);
		}
		System.out.println();
	}

	public static int hashIt(String data)
	{
		int asciiTotal = 0;
		for (int n = 0; n < data.length(); n++)
		{
			char c = data.charAt(n);
			asciiTotal = asciiTotal + (int)c;
		}
		return asciiTotal % hashArray.length;
	}
	
	public static void appendNode(int arrayIndex, int customerID, String name)
	{
		if (hashArray[arrayIndex] == null)
		{
			hashArray[arrayIndex] = new HashNode(customerID, name);
		}
		else
		{
			HashNode current = hashArray[arrayIndex];
			while (current.next != null)
			{
				current = current.next;
			}
			current.next = new HashNode(customerID, name);
		}
	}

	public static void displayHashArray()
	{
		for (int i = 0; i < hashArray.length; i++)
		{
			System.out.printf("hashArray[%d]", i);
			if (hashArray[i] != null)
			{
				HashNode current = hashArray[i];
				System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				while (current.next != null)
				{
					current = current.next;
					System.out.printf(" -> [%d][%s]", current.customerID, current.lastName);
				}
			}
			System.out.println();;
		}
	}
}
