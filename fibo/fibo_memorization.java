import java.util.*;

class fibo_memorization {
    public static int fibo(int arr[], int n) {
        if (arr[n] != -1) {
            return arr[n];
        } else {
            if (n == 0) {
                return arr[n] = 0;
            } else if (n == 1) {
                return arr[n] = 1;
            } else {
                return arr[n] = fibo(arr, n - 1) + fibo(arr, n - 2);
            }
        }
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
