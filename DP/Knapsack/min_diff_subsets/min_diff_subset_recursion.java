import java.util.*;
import java.lang.*;

class knapsack
{
    public static int ks(int arr[],int n,int sum,int currentsum)
    {
        if(n==0)
        {
            return Math.abs((sum-currentsum)-currentsum);
        }
        
        int include=ks(arr,n-1,sum,currentsum+arr[n-1]);

        int exclude=ks(arr,n-1,sum,currentsum);

        return Math.min(include,exclude);
    }
}

class min_diff_subset_recursion
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter Array Elements :");
            arr[i]=sc.nextInt();
        }

        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum=sum+arr[i];
        }

        knapsack k=new knapsack();
        int res=k.ks(arr,n,sum,0);

        System.out.println("Minimum Difference Between Subsets Is :"+res);
    }
}
