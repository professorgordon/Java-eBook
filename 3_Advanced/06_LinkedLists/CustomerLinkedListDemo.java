/*
 * CustomerLinkedListDemo.java - Driver for customer linked list.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancednodes.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class CustomerLinkedListDemo 
{

	public static void main(String[] args) 
	{
		// Instantiate linked list
		CustomerLinkedList cll = new CustomerLinkedList();

		// Append nodes
		cll.append(555555,"Lester","Scroggs",43.56);
        cll.append(666666,"Bert","Smith",27.99);
        cll.append(777777,"Bob","Jones",45.92);
        cll.append(888888,"Sally","Gomez",84.17);
        cll.append(999999,"Mario","Plumm",20.00);
        cll.printCustomerList();

        // Prepend node (replace head)
        cll.prepend(444444,"Ralph","Martinez",56.29);
        cll.printCustomerList();

        // Delete nodes
        cll.delete(888888);
        cll.delete(666666);
        cll.delete(555555);
        cll.printCustomerList();
	
        // Demostrate search options
        System.out.print("\n\n");
        cll.printLine(35);
        System.out.print("Search Examples\n");
        cll.printLine(35);
        
        // Search by account number and return customer compound string
        System.out.println("Search by account number & return customer string:");
        System.out.println(cll.searchReturnString(777777));

        // Search by customer name and return customer compound string
        System.out.println("\nSearch by customer name & return customer string:");
        System.out.println(cll.searchReturnString("Mario", "Plumm"));

        // Search by account number and return object reference to node,
        // then use the reference to access the node object's attributes
        System.out.println("\nSearch by account number & return reference:");
        CustomerNode customer = null;
        customer = cll.searchReturnReference(777777);
        System.out.printf("Customer: %d Name: %s %s Balance: $%,.2f\n", 
        					customer.accountNumber, customer.firstName, 
        					customer.lastName, customer.accountBalance);
	}

}
