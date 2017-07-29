import java.io.*;
import java.util.*;

public class ListNode
{
	int val;
	ListNode next;

	ListNode(int x)
	{
		val = x;
	}
}

class LinkedListOperations
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
	}

	public ListNode addTwoLinkedLists(ListNode l1, ListNode l2)
	{
        	ListNode c1 = l1;
        	ListNode c2 = l2;
        	ListNode sentinel = new ListNode(0);
        	ListNode d = sentinel;
        	int sum = 0;
        	while (c1 != null || c2 != null)
		{
            		sum /= 10;

            		if (c1 != null)
			{
                		sum += c1.val;
                		c1 = c1.next;
            		}

            		if (c2 != null)
			{
                		sum += c2.val;
                		c2 = c2.next;
            		}

            		d.next = new ListNode(sum % 10);
            		d = d.next;
        	}

        	if (sum / 10 == 1)
            		d.next = new ListNode(1);

        	return sentinel.next;
    	}

	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2)
    	{
        	if(l1 == null)
            		return l2;
            
        	if(l2 == null)
            		return l1;
            
        	ListNode sorted;
        
        	if(l1.val < l2.val)
        	{
            		sorted = l1;
            		sorted.next = mergeTwoLists(l1.next, l2);
        	}
        	else
        	{
            		sorted = l2;
            		sorted.next = mergeTwoLists(l1, l2.next);
        	}
        
        	return sorted;
    	}
}