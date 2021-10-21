/*
 * BinarySearchTree.java - Class to manage binary search 
 *                         tree implementations.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class BinarySearchTree 
{
	public BSTNode root;

	public void insert(int data)
	{
		BSTNode newNode = new BSTNode(data);  
		if(root == null)
		{  
			root = newNode;  
			return;  
		}  
		else
		{  
			BSTNode current = root, parent = null;  
			while(true) 
			{  
				parent = current;  
				if(data < current.data)
				{  
					current = current.left;  
					if(current == null)
					{  
						parent.left = newNode;  
						return;  
					}  
				}  
				else
				{  
					current = current.right;  
					if(current == null)
					{  
						parent.right = newNode;  
						return;  
					}  
				}  
			}  
		}  
	}

	public void preOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			System.out.print(n.data + " ");  
			if(n.left!= null)
			{
				preOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				preOrderTraverse(n.right);  
			}
		}  
	}  

	public void inOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				inOrderTraverse(n.left);  
			}
			System.out.print(n.data + " ");  
			if(n.right!= null)
			{
				inOrderTraverse(n.right);  
			}
		}  
	}  

	public void postOrderTraverse(BSTNode n)
	{  
		if(root == null)
		{  
			System.out.println("Tree is empty");  
			return;  
		}  
		else
		{  
			if(n.left!= null)
			{
				postOrderTraverse(n.left);  
			}
			if(n.right!= null)
			{
				postOrderTraverse(n.right);  
			}
			System.out.print(n.data + " ");  
		}  
	}  

}
