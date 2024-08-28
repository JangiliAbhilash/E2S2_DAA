import java.util.*;
import java.lang.*;

class knapsack
{

	public int ks(int arr[][],int wt[],int val[],int w,int n)
	{
	
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				if(i==0 || j==0)
				{
					arr[i][j]=0;
				}
				
				
				else if(wt[i-1]<=j)
				{
					arr[i][j]= Math.max(val[i-1]+arr[i-1][j-wt[i-1]],arr[i-1][w]);
					
				}
				else
				{
					arr[i][j]=arr[i-1][j];
					

				}
			}
		}
		return arr[n][w];
	}
}

class knapsack_tabulization
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
		System.out.println("Enter Total Capacity Of The Bag :");
		int w=sc.nextInt();
		
		int arr[][]=new int[n+1][w+1];
		
		knapsack k=new knapsack();
		int result=k.ks(arr,wt,val,w,n);
		
		System.out.println("Maximum Value That Can Be Obtained :"+result);
		
	}
}
