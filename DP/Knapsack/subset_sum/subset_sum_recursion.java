import java.util.*;

/*

if the sum of any elements in the given list is equal to 'w' value then it will return true or else false

wt= 5 3 2 9 6
w= 17

2+9+6=17

therefore TRUE.

*/

class knapsack
{

	public boolean ks(int wt[],int w,int n)
	{
		if(w==0)
		{
			return true;
		}
		if(n==0)
		{
			return false;
		}
		if(wt[n-1]<=w)
		{
			return ks(wt,w-wt[n-1],n-1) || ks(wt,w,n-1);
		}
		else
		{
			return ks(wt,w,n-1);
		}
	}
}

class subset_sum_recursion
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
		
		
		knapsack k=new knapsack();
		boolean result=k.ks(wt,w,n);
		
		System.out.println("The Total Minimum Number Of coins Required Is :"+result);
		
	}
}
