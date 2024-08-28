import java.util.*;
import java.lang.*;

class knapsack
{

	private static int max(int a,int b)
	{
		return(a>b)?a:b;
	}
	public int ks(int arr[][],int wt[],int val[],int w,int n)
	{
		if(n==0 || w==0)
		{
			return 0;
		}
		
		if(arr[n][w]!=-1)
		{
			return arr[n][w];
		}
		
		if(wt[n-1]>w)
		{
			return arr[n][w]=ks(arr,wt,val,w,n-1);
			
		}
		else
		{
			return arr[n][w]= max(val[n-1]+ks(arr,wt,val,w-wt[n-1],n-1),ks(arr,wt,val,w,n-1));

		}
	}
}

class knapsack_memorization
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int j=0;
		System.out.println("Enter total number of weights and Values :");
		int n=sc.nextInt();
		int wt[]=new int[n];
		int val[]=new int[n];
		
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Weights :");
			wt[i]=sc.nextInt();
			
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Values :");
			val[i]=sc.nextInt();
		}
		System.out.println("Enter Total Capacity Of the Bag :");
		int w=sc.nextInt();
		
		int arr[][]=new int[n+1][w+1];
		for(int[] row:arr)
		{
			Arrays.fill(row,-1);
		}
		
		knapsack k=new knapsack();
		int result=k.ks(arr,wt,val,w,n);
		
		System.out.println("Maximum Value That Can Be Obtained :"+result);
		
	}
}
