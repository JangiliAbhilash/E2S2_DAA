import java.util.*;

class nqueens {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens:");
        int n = sc.nextInt();
        int arr[] = new int[n]; // Array size adjusted
        System.out.println("---------------");
        fill(0, n, arr); // Start from 0th index
    }

    public static void fill(int k, int n, int arr[]) {
        if (k == n) {
            // All queens are placed correctly, print the solution
            printSolution(arr);
            return;
        }
        for (int i = 0; i < n; i++) { // Iterate through all columns
            if (isSafe(k, i, arr)) {
                arr[k] = i;
                fill(k + 1, n, arr);
            }
        }
    }

    public static boolean isSafe(int row, int col, int arr[]) {
        for (int i = 0; i < row; i++) {
            // Check if placing a queen at this position conflicts with existing queens
            if (arr[i] == col || Math.abs(row - i) == Math.abs(col - arr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) 
        {
        	System.out.print(arr[i]+" ");
        }
        System.out.prinln();
    }
}

