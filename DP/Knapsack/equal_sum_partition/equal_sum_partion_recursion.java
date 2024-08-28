import java.util.*;
import java.lang.*;

class knapsack
{
    public static boolean ks(int arr[],int currentindex,int sum,int target)
    {
        if(sum==target)
        {
            return true;
        }
        if(currentindex == arr.length || sum>target)
        {
            return false;
        }
        
        boolean include=ks(arr,currentindex+1,sum+arr[currentindex],target);

        boolean exclude=ks(arr,currentindex+1,sum,target);
        
        return include || exclude;
    }		
}

class equal_sum_partion_recursion	
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
        
        int target=sum/2;

        knapsack k=new knapsack();
        boolean res=k.ks(arr,0,0,target);
        if(res==true)
        {
            System.out.println("yes We Can Do Equal Sum Partion: the result is "+res);
        }
        else
        {
            System.out.println("Oops! We Can't Do Equal Sum Partion. the result is"+res);
        }
    }
}
