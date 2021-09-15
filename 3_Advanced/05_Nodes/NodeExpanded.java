/*
 * NodeExpanded.java - Node example with added instance variables.
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancednodes.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 */

public class NodeExpanded
{
  NodeExpanded next;
  int key;
  String fname;
  String lname;
  double balance;
	
  public NodeExpanded(int key, String fname, 
                      String lname, double balance)
  {
    this.key = key;
    this.fname = fname;
    this.lname = lname;
    this.balance = balance;
  }
}
