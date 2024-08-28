import java.util.*;
import java.lang.*;

class knapsack
{

	public boolean ks(boolean arr[][],int wt[],int w,int n)
	{
		if(w==0)
		{
			return arr[n][w]=true;
		}
		if(n==0)
		{
			return arr[n][w]=false;
		}
		if(wt[n-1]<=w)
		{
			return arr[n][w]= ks(arr,wt,w-wt[n-1],n-1) || ks(arr,wt,w,n-1);
		}
		else
		{
			return arr[n][w]=ks(arr,wt,w,n-1);
		}
	}
}

class subset_sum_memorization
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
		
		
		System.out.println("Enter Coin that You want change :");
		int w=sc.nextInt();
		
		boolean arr[][]=new boolean[n+1][w+1];
		
		knapsack k=new knapsack();
		boolean result=k.ks(arr,wt,w,n);
		
		System.out.println("The Total Minimum Number Of coins Required Is :"+result);
		
	}
}
