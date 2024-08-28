import java.util.*;
import java.lang.*;

class knapsack
{
    public static int ks(int arr[][],int wt[],int val[],int n,int W)
    {
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0 || j==0)
                {
                    arr[i][j]=0;
                }
                
                else if(wt[i-1]<=j)
                {
                    arr[i][j]=Math.max(val[i-1]+arr[i-1][j-wt[i-1]],arr[i-1][j]);
                }
                else
                {
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[n][W];
        
    }
}

class knapsack_tabulization
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Values :");
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

        System.out.println("Enter Total Capacity Of the Bag :");
        int W=sc.nextInt();

        int arr[][]=new int[n+1][W+1];
        for(int[] row:arr)
        {
            Arrays.fill(row,-1);
        }

        knapsack k=new knapsack();
        int res=k.ks(arr,wt,val,n,W);

        System.out.println(res);
    }
}
