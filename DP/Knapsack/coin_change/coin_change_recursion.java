import java.util.*;

class knapsack
{
	public int ks(int wt[],int w,int n)
	{
		if(w==0)
		{
			return 1;
		}
		if(n==0)
		{
			return 0;
		}
		if(n==0 && w==0)
		{
			return 1;
		}
		if(wt[n-1]<=w)
		{
			return ks(wt,w-wt[n-1],n) + ks(wt,w,n-1);
		}
		else
		{
			return ks(wt,w,n-1);
		}
	}
}

class coin_change_recursion
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
		
		knapsack k=new knapsack();
		int result=k.ks(wt,w,n);
		
		System.out.println("The Total Number Of Possible Ways to give change for Given coin Is :"+result);
		
	}
}
