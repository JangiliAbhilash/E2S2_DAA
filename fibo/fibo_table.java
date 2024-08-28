import java.util.*;

class fibo_table {
    public static int fibo(int arr[], int n) {

        for(int i=0;i<=n;i++){
            
            if(i==0){
                arr[i]=0;
            }
            else if(i==1){
                arr[i]=1;
            }
            else
            {
                arr[i]=arr[i-1]+arr[i-2];
            }
        }
        return arr[n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number :");
        int n = sc.nextInt();

        // Ensure the array is of size n + 1
        int arr[] = new int[n + 1];
        // Initialize the array with -1
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }
        int res = fibo(arr, n);
        System.out.println("Fibonacci Sequence Value at Position " + n + " is: " + res);
    }
}
