/*
 * customerLinkedList.java - Class to manage linked lists of 
 *                           customer data.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedlinkedlists2.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 * ---------------------------------------------------------- 
 * Methods included in this implementation demo
 * ---------------------------------------------------------- 
 * 	append()
 *  delete()
 *  length()
 *  prepend()
 *  printCustomerList()
 *  searchReturnString()	[overloaded]
 *  searchReturnReference()
 *  printLine()
 *
 * ---------------------------------------------------------- 
 * Suggested methods to add
 * ---------------------------------------------------------- 
 *  clear()
 *  contains()
 *  occurrences()
 *  deleteHead()
 *  deleteTail()
 *  deleteFirstOccurrence()
 *  deleteLastOccurrence()
 *  deleteAllOccurrences()
 *  fromArray()
 *  getPosition()
 *  insert()
 *  isEmpty()
 *  printList()
 *  reverseList()
 *  toArray()
 *  
 * ---------------------------------------------------------- 
 *  
 */

public class CustomerLinkedList 
{

	CustomerNode head;
	
	
	public void append(int accountNumber, 
						String firstName, 
						String lastName, 
						double accountBalance)
	{
		if (head == null)
		{
			head = new CustomerNode(accountNumber,
									firstName,
									lastName,
									accountBalance);
			return;
		}
		CustomerNode current = head;
		while (current.next != null)
		{
			current = current.next;
		}
		current.next = new CustomerNode(accountNumber, 
										firstName,
										lastName,
										accountBalance);
	}
	
	
	public void delete(int accountNumber)
	{
		CustomerNode current = head;
		CustomerNode previous = null;
		if (head != null && current.accountNumber == accountNumber)
		{
			head = current.next;
			return;
		}
		while (current != null && current.accountNumber != accountNumber)
		{
			previous = current;
			current = current.next;
		}
		if (current == null)
		{
			return;
		}
		previous.next = current.next;
	}

	
	public int length()
	{
		int len = 0;
		CustomerNode current = head;
		while (current != null)
		{
			len++;
			current = current.next;
		}
		return len;

	}

	
	public void prepend(int accountNumber, 
			String firstName, 
			String lastName, 
			double accountBalance)
	{
		CustomerNode newHead = new CustomerNode(accountNumber, 
												firstName,
												lastName,
												accountBalance);
		newHead.next = head;
		head = newHead;
	}

	
	public void printCustomerList()
	{
		CustomerNode current = head;
		System.out.println();
		printLine(35);
		System.out.print("C u s t o m e r   L i s t\n");
		printLine(35);
		System.out.println("Account\tCustomer\t\tBalance");
		printLine(35);
		while (current != null)
		{
			System.out.printf("%d\t%s %s\t$%,.2f\n", 
							current.accountNumber, current.firstName, 
							current.lastName, current.accountBalance);
			current = current.next;
		}
	}

	
	public String searchReturnString(int accountNumber)
	{
	    String result = "Not found";
	    if (head == null) return "Empty List";
	    CustomerNode current = head;
	    if (head.accountNumber == accountNumber)
	    {
	        result = "Customer Account: " + head.accountNumber
	            + " Name: " + head.firstName + " "
	            + head.lastName + " Balance: $"
	            + head.accountBalance;
	    }
	    else
	    {
	        while (current.next != null)
	        {
	            if (current.next.accountNumber == accountNumber)
	            {
	                result = "Customer Account: " + current.next.accountNumber
	                    + " Name: " + current.next.firstName + " "
	                    + current.next.lastName + " Balance: $"
	                    + current.next.accountBalance;
	            }
	            current = current.next;
	         }
	    }
	    return result;
	}


	public String searchReturnString(String firstName, 
									String lastName)
	{
		String result = "Not found";
	    if (head == null) return "List Empty";
	    CustomerNode current = head;
	    if (head.firstName.equalsIgnoreCase(firstName) && 
	    	head.lastName.equalsIgnoreCase(lastName))
	    {
	    	result = "Customer Account: " + head.accountNumber
	            + " Name: " + head.firstName + " "
	            + head.lastName + " Balance: $"
	            + head.accountBalance;
	    }
	    else
	    {
	        while (current.next != null)
	        {
	            if (current.next.firstName.equalsIgnoreCase(firstName) && 
	            	current.next.lastName.equalsIgnoreCase(lastName))
	            {
	                result = "Customer Account: " + current.next.accountNumber
	                    + " Name: " + current.next.firstName + " "
	                    + current.next.lastName + " Balance: $"
	                    + current.next.accountBalance;
	                break;
	            }
	            current = current.next;
	        }
	    }
	    return result;
	}


	public CustomerNode searchReturnReference(int accountNumber)
	{
	    CustomerNode result = null;
	    if (head == null) return null;
	    CustomerNode current = head;
	    if (head.accountNumber == accountNumber)
	    {
	        result = current;
	    }
	    else
	    {
	        while (current.next != null)
	        {
	            if (current.next.accountNumber == accountNumber)
	            {
	            	result = current.next;
	            }
	            current = current.next;
	         }
	    }
	    return result;
	}
	

	public void printLine(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
	
}
