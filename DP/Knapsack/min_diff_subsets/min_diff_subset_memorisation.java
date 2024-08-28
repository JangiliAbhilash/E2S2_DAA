import java.util.*;
import java.lang.*;

class knapsack
{
    public static int ks(int arr[],int sum,int currentindex,int currentsum,int temp[][])
    {
        if(currentindex==arr.length)
        {
            return Math.abs(sum-2*currentsum);
        }
        if(temp[currentindex][currentsum]!=-1)
        {
            return temp[currentindex][currentsum];
        }
        
        int include=ks(arr,sum,currentindex+1,currentsum+arr[currentindex],temp);

        int exclude=ks(arr,sum,currentindex+1,currentsum,temp);
        
        temp[currentindex][currentsum]=Math.min(include,exclude);
        
        return temp[currentindex][currentsum];
    }
}

class min_diff_subset_memorisation
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
        int temp[][]=new int[n+1][sum+1];

         for (int i = 0; i <= n; i++) {
            Arrays.fill(temp[i], -1);
        }


        knapsack k=new knapsack();
        int res=k.ks(arr,sum,0,0,temp);

        System.out.println("Minimum Difference Between Subsets Is "+res);
    }
}
