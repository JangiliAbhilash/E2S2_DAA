import java.util.*;

/**
 * aa
 */
public class equal_sum_partion_memorization {

    public static boolean ks(boolean arr[][],int wt[],int ci, int sum,int target){

        if(sum==target){
            return arr[ci][sum] = true;
        }
        if(ci == wt.length || sum > target){
            return arr[ci][sum] = false;
        }

        boolean in = ks(arr,wt, ci+1, sum+wt[ci], target);
        boolean ex = ks(arr,wt, ci+1, sum, target);

        arr[ci][sum] = in || ex;
        return arr[ci][sum];
    
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Total Values :");
        int n=sc.nextInt();

        // int wt[] = new int[n];
        int val[] = new int[n];

        for(int i=0;i<n;i++){
            // System.out.println("Enter Weights :");
            // wt[i]=sc.nextInt();
            System.out.println("enter Values :");
            val[i]=sc.nextInt();
        }

        // System.out.println("Enter Total bag Weight :");
        // int W=sc.nextInt();
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=val[i];
        }
        int target=sum/2;

        boolean arr[][]=new boolean[n+1][sum+1];
        // for(int i=0;i<=n;i++){
        //      Arrays.fill(arr[i],-1);
        //  }

        boolean res=ks(arr,val,0,0,target);
        System.out.println("maximum value that can be obtained :"+res);
    }
}
