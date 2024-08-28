import java.util.*;
import java.lang.*;

class knapsack
{
    public static int ks(int arr[][],int wt[],int n,int W)
    {
        for( int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                
                if(j==0)
                {
                    arr[i][j]= 1;
                }

                else if(i==0)
                {
                    arr[i][j]= Integer.MAX_VALUE-1000;
                }
                
                else if(wt[i-1]<=j)
                {
                    arr[i][j]= Math.min(1+arr[i][j-wt[i-1]] , arr[i-1][j]);
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

class min_number_of_coins_tabulization
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
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
        int W=sc.nextInt();

        int arr[][]=new int[n+1][W+1];
        
        knapsack k=new knapsack();
        int res=k.ks(arr,wt,n,W);

        System.out.println("The Total Minimum Number Of coins Required Is :"+res);
    }
}
