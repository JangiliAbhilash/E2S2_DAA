import java.util.*;

class ks
{
	public int knap(int wt[],int val[],int W,int n)
	{
		if(n==0 || W==0)
		{
			return 0;
		}
		
		if(wt[n-1]<=W)
		{
			return Math.max(val[n-1]+knap(wt,val,W-wt[n-1],n-1),knap(wt,val,W,n-1));
		}
		else
		{
			return knap(wt,val,W,n-1);
		}
	}
}

class knapsack
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Lists :");
		int n=sc.nextInt();
		
		int wt[]=new int[n];
		int val[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter "+i+1+" Weight :");
			wt[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter "+i+1+" Values :");
			val[i]=sc.nextInt();
		}
		
		System.out.println("Enter Capacity Of The Bag :");
		int W=sc.nextInt();
		
		ks k=new ks();
		
		int result=k.knap(wt,val,W,n);
		System.out.println("Maximum Value That Can Be Obtained :"+result);
	}
}
