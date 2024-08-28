import java.util.*;

/*

wt= 5 3 2 1 4
w= 7

The Question Is how many ways are there to get '7' if we add the elements.

5,2
2,1,4
3,4

There are 3 possible ways are there for above example

*/

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
		if(wt[n-1]<=w)
		{
			return ks(wt,w-wt[n-1],n-1) + ks(wt,w,n-1);
		}
		else
		{
			return ks(wt,w,n-1);
		}
	}
}

class number_of_ways_recursion
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int j=0;
		System.out.println("Enter Array Size :");
		int n=sc.nextInt();
		int wt[]=new int[n];
		
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Weights :");
			wt[i]=sc.nextInt();
			
		}
		System.out.println("Enter Total Capacity Of The Bag :");
		int w=sc.nextInt();
		
		knapsack k=new knapsack();
		int result=k.ks(wt,w,n);
		
		System.out.println("The Total Number Of Possible Ways are :"+result);
		
	}
}
