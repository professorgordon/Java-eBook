/*
 * Notes about deleting nodes:
 * 
 * - There are three possible scenarios:
 * 		1. The node is in the left subtree 
 * 		2. The node is in the right subtree 
 * 		3. The node is the tree root
 * 
 * - We traverse the tree to find the node to delete.
 * 
 * - Then, there are three possible conditions:
 * 		1. The node is a leaf, so delete it.
 * 		2. The node has 1 child, replace the node with its child.  
 * 		3. The node has 2 children, replace the node with its
 * 		   inorder successor. The inorder predecessor could be
 * 		   used as an option as well. The inorder successor 
 * 		   is only required with the right child is present,
 * 		   in that case, the inorder successor can be found 
 * 		   by locating the minimum right-child value.
 */

public class BSTDeleteDemo 
{

	public static BinarySearchTree bst = new BinarySearchTree();

	public static void main(String[] args) 
	{
		loadTree(bst.root);
		printtree(bst.root);

		// Delete a right-branch leaf
		BinarySearchTree.deleteNode(bst.root, 55);
		/* Now it looks like this ...
 
		        50
		       /  \
		     46    51
		     / \
		   40   48
		  / \
		38   42
		     / \
		   41   43
		
		*/
		printtree(bst.root);
		
		// Delete a left-branch leaf
		BinarySearchTree.deleteNode(bst.root, 43);
		/* Now it looks like this ...
		 
		        50
		       /  \
		     46    51
		     / \
		   40   48
		  / \
		38   42
		     /
		   41
		
		*/
		printtree(bst.root);

		// Delete a node with two child nodes
		BinarySearchTree.deleteNode(bst.root, 46);
		/* Now it looks like this ...
		 
		        50
		       /  \
		     48    51
		     /
		   40
		  / \
		38   41
		
		*/
		printtree(bst.root);
		
		// Delete the root node
		BinarySearchTree.deleteNode(bst.root, 50);
		/* Now it looks like this ...
		 
		        51
		       /
		     48
		     /
		   40
		  / \
		38   41
		
		*/
		printtree(bst.root);
		
	}

	private static void loadTree(BSTNode root)
	{
		/* Original tree ...

		        50
		       /  \
		     46    51
		     / \     \ 
		   40   48    55
		  / \
		38   42
		     / \
		   41   43
		
		*/
		bst.insert(50);
		bst.insert(46);
		bst.insert(48);
		bst.insert(40);
		bst.insert(42);
		bst.insert(38);
		bst.insert(41);
		bst.insert(43);
		bst.insert(51);
		bst.insert(52);
		bst.insert(53);
		bst.insert(54);
		bst.insert(55);
	}

	public static void printtree(BSTNode root)
	{
		System.out.println();
		System.out.print("PreOrder Traverse:\t");
		bst.preOrderTraverse(root);
		System.out.println();
		System.out.print("InOrder Traverse:\t");
		bst.inOrderTraverse(root);
		System.out.println();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrderTraverse(root);
		System.out.println();
	}
}
