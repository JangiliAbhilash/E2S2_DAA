import java.util.*;

class Hamiltonian_cycle_from_sourcenode {
    static int a[] = new int[10];
    static int adj[][] = new int[10][10];
    static int startNode;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the total number of nodes:");
        n = sc.nextInt();
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the starting node:");
        startNode = sc.nextInt();
        System.out.println("----------------");
        a[0] = startNode; // Set the first node as the starting node
        fill(n, 1); // Start from the next node
    }

    public static void fill(int n, int k) {
        if (k == n) {
            if (adj[a[k - 1]][a[0]] == 1) { // Ensure it forms a cycle
                print(a, n);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(k, i, n)) {
                a[k] = i;
                fill(n, k + 1);
            }
        }
    }

    public static boolean isSafe(int k, int i, int n) {
        for (int j = 0; j < k; j++) {
            if (a[j] == i) {
                return false;
            }
        if (adj[a[k - 1]][i] == 0) {
            return false;
        }
        if (k == n - 1 && adj[i][a[0]] == 0) {
            return false;
        }
        }
        return true;
    }

    public static void print(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}





/*

inputs

0 1 0 0 0 1       
1 0 1 0 1 0
0 1 0 1 0 1
0 0 1 0 1 0
0 1 0 1 0 1
1 0 1 0 1 0

*/
