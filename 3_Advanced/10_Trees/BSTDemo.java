/*
 * BSTDemo.java - Class to demonstrate a binary search tree.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 **/

public class BSTDemo 
{
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		// Sample Data: 20, 33, 18, 19, 46, 29, 4, 62
		bst.insert(20);
		bst.insert(33);
		bst.insert(18);
		bst.insert(19);
		bst.insert(46);
		bst.insert(29);
		bst.insert(4);
		bst.insert(62);
		System.out.print("PreOrder Traverse:\t");
		bst.preOrderTraverse(bst.root);
		System.out.println();
		System.out.print("InOrder Traverse:\t");
		bst.inOrderTraverse(bst.root);
		System.out.println();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrderTraverse(bst.root);
		System.out.println();
	}
}
