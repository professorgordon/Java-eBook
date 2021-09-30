/*
 * CustomerNode.java - Example of enhanced OOP node.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancednodes.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class CustomerNode 
{
    CustomerNode next;
    int accountNumber;
    String firstName;
    String lastName;
    double accountBalance;

    public CustomerNode(int accountNumber, String firstName,
                        String lastName, double accountBalance)
    {
         this.accountNumber = accountNumber;
         this.firstName = firstName;
         this.lastName = lastName;
         this.accountBalance = accountBalance;
    }
}
