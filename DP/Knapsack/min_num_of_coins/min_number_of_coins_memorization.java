import java.util.*;
import java.lang.*;

class knapsack
{
	public int ks(int arr[][],int wt[],int w,int n)
	{
		if(arr[n][w]!=-1)
		{
			return arr[n][w];
		}
		if(w==0)
		{
			return arr[n][w]=1;
		}
		if(n==0)
		{
			return arr[n][w]=Integer.MAX_VALUE-1000;
		}
		
		if(wt[n-1]<=w)
		{
			return arr[n][w]= Math.min(1+ks(arr,wt,w-wt[n-1],n),ks(arr,wt,w,n-1));
		}
		else
		{
			return arr[n][w]= ks(arr,wt,w,n-1);
		}
	}
}

class min_number_of_coins_memorization
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int j=0;
		System.out.println("Enter total number of coins :");
		int n=sc.nextInt();
		int wt[]=new int[n];
		int val[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Coin Values :");
			wt[i]=sc.nextInt();
			
		}
		System.out.println("Enter Coin that You want change :");
		int w=sc.nextInt();
		
		int arr[][]=new int[n+1][w+1];
		for(int[] row:arr)
		{
			Arrays.fill(row,-1);
		}
		
		knapsack k=new knapsack();
		int result=k.ks(arr,wt,w,n);
		
		System.out.println("The Total Minimum Number Of coins Required Is :"+result);
		
	}
}
