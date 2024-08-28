import java.util.*;

class subset_sum_tabulation{

    public static boolean knapsack(boolean arr[][],int val[],int W,int n){
        
      for(int i=0;i<=n;i++){
        for(int j=0;j<=W;j++){
            if(i==0){
                arr[i][j] = false;
            }
            else if(j==0){
                arr[i][j] = true;
            }
            else if(val[i-1]<=j){
                arr[i][j] = arr[i-1][j-val[i-1]] || arr[i-1][j];
            }
            else{
                arr[i][j] = arr[i-1][j];
            }
        }
      }
      return arr[n][W];
         

    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number Of Values :");
        int n=sc.nextInt();

        int val[]=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter Values :");
            val[i]=sc.nextInt();
            
        }

        System.out.println("Enter Subset Sum :");
        int W=sc.nextInt();

        boolean arr[][]=new boolean[n+1][W+1];
        
        
        boolean result=knapsack(arr,val,W,n);
        System.out.println("Result ="+result);
    }
}
