import java.io.*;
import java.util.*;

class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data=data;
		right=null;
		left=null;
	}
}

class BinaryTreeOperations
{
	public static Node root;

	public BinaryTreeOperations()
	{
		this.root=null;
	}

	public void insert(int key)
	{
		Node newNode=new Node(key);
		Node current=root;
		Node parent=null;
		if(root==null)
		{
			root=newNode;
			return;
		}
		while(true)
		{
			parent=current;
			if(key<current.data)
			{
				current=current.left;
				if(current==null)
				{
					parent.left=newNode;
					return;
				}
			}
			else
			{
				current=current.right;
				if(current==null)
				{
					parent.right=newNode;
					return;
				}
			}
			
		}
	}

	public void display(Node key)
	{
		if(key!=null)
		{
			display(key.left);
			System.out.print(key.data+" ");
			display(key.right);
		}
	}

	public Node getSuccessor(Node deleted)
	{
		Node successor=null;
		Node sparent=null;
		Node current=deleted.right;
		while(current!=null)
		{
			sparent=successor;
			successor=current;
			current=current.left;
		}
		if(successor!=deleted.right)
		{
			sparent.left=successor.right;
			successor.right=deleted.right;
		}
		return successor;
	}

	public boolean delete(int key)
	{
		Node current=root;
		Node parent=root;
		boolean isleftchild=false;
		while(key!=current.data)
		{
			parent=current;
			if(key<current.data)
			{
				current=current.left;
				isleftchild=true;
			}
			else
			{
				current=current.right;
				isleftchild=false;
			}
			if(current==null)
			{
				return false;
			}
		}

		if(current.left==null && current.right==null)
		{
			if(current==root)
				root=null;
			if(isleftchild==true)
				parent.left=null;
			else
				parent.right=null;
		}
		else
			if(current.left==null)
			{
				if(current==root)
					root=current.right;
				else
					if(isleftchild)
						parent.left=current.right;
					else
						parent.right=current.right;
			}
			else
				if(current.right==null)
				{
					if(current==root)
						root=current.left;
					else
						if(isleftchild)
							parent.left=current.left;
						else
							parent.right=current.left;
				}
				else
					if(current.left!=null && current.right!=null)
					{
						Node successor=getSuccessor(current);
						if(current==root)
							root=successor;
						else
							if(isleftchild)
								parent.left=successor;
							else
								parent.right=successor;
						successor.left=current.left;
					}
		return true;
	}

	public static void printLeafNodes(Node node)
	{
		if(node==null)
			return;
		if(node.left == null && node.right == null)
			System.out.print(node.data+" ");
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}

	public static void main(String args[])throws IOException
	{
		BinaryTreeOperations obj = new BinaryTreeOperations();
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of nodes you want to insert: ");
		int n=s.nextInt();
		System.out.print("Enter the Nodes: ");
		for(int i=0; i<n; i++)
			obj.insert(s.nextInt());
		System.out.print("Currently the sorted Tree is as follows: ");
		obj.display(root);
		System.out.println("\n");
		char rep='Y';
		int choice;
		while(rep=='Y' || rep=='y')
		{
			System.out.print("\nOperations:\n\n1. Insert Node\n2. Delete Node\n3. Print the Leaf Nodes\n4. Display the Tree\n\nWhats your command? :- ");
			choice=s.nextInt();
			switch(choice)
			{
				case 1 : System.out.print("Enter the Node you want to insert: ");
					obj.insert(s.nextInt());
					break;
				case 2 : System.out.print("Enter the Node you want to delete: ");
					obj.delete(s.nextInt());
					break;
				case 3 : System.out.print("The Leaf nodes are: ");
					obj.printLeafNodes(root);
					System.out.println();
					break;
				case 4 : System.out.println("Currently the sorted Tree is: ");
					obj.display(root);
					System.out.println();
					break;
				default : System.out.print("Invalid Selection!");
						break;
			}
			System.out.println("Do you want to continue(Y/N)?");
			rep=s.next().charAt(0);
			if(rep=='N' || rep=='n')
				System.out.println("Bye Bye!");
		}
		
	}
}