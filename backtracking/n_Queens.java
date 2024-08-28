import java.util.*;
import java.lang.*;

class n_Queens
{
	public static void nQueens(int k,int n,int arr[])
	{
		if(k==n)
		{
			printSolution(arr);
			return;
		}
		for(int i=0;i<n;i++)
		{
			if(isSafe(k,i,arr))
			{
				arr[k]=i;
				nQueens(k+1,n,arr);
			}
		}
	}
	
	public static boolean isSafe(int row,int col,int arr[])
	{
		for(int i=0;i<row;i++)
		{
			if(arr[i]==col || Math.abs(row-i) == Math.abs(col-arr[i])){
				return false;
			}
		}
		return true;
	}
	
	public static void printSolution(int arr[])
	{
		System.out.print("Result :");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Queens :");
		int n=sc.nextInt();
		int arr[]=new int[n];
		
		
		nQueens(0,n,arr);
	}
}
