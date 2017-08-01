import java.io.*;
import java.util.*;

class BubbleSort
{
	public static void main(String args[])
	{
		int[] arr = new int[]{7,6,3,2,5};
		BubbleSort obj = new BubbleSort();
		obj.bubble(arr);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}

	public void bubble(int[] arr)
	{
		for(int i=0; i<arr.length-1; i++)
			for(int j=0; j<arr.length-1-i; j++)
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}
}