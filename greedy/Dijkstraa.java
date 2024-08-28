import java.util.Scanner;
import java.util.Arrays;

public class Dijkstraa {

    static final int MAX = 100;
    static final int INF = Integer.MAX_VALUE;

    // Global variables
    static int[][] adj = new int[MAX][MAX];  // Adjacency matrix
    static int[] p = new int[MAX];           // Parent array for storing shortest path
    static boolean[] v = new boolean[MAX];   // Visited array
    static int[] cost = new int[MAX];        // Cost array
    static int n;                            // Number of vertices

    // Function to find the node with the minimum cost that has not been visited
    static int findMinNode() {
        int min = INF;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (!v[i] && cost[i] < min) {
                min = cost[i];
                index = i;
            }
        }

        return index;
    }

    // Function that implements Dijkstra's algorithm
    static void dijkstra(int src) {
        int k = n;
        while (k > 0) {
            int i = findMinNode();
            if (i == -1) break;  // No more reachable nodes
            v[i] = true;

            for (int j = 0; j < n; j++) {
                if (adj[i][j] != INF && !v[j]) {
                    if (cost[j] > cost[i] + adj[i][j]) {
                        cost[j] = cost[i] + adj[i][j];
                        p[j] = i;
                    }
                }
            }

            k--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        n = sc.nextInt();

        System.out.println("Enter the adjacency matrix (-1 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = sc.nextInt();
                if (adj[i][j] == -1) {
                    adj[i][j] = INF; // Use INF to represent no edge
                }
            }
        }

        System.out.print("Enter the source vertex: ");
        int src = sc.nextInt();

        // Initialize arrays
        Arrays.fill(v, false);     // false means not visited
        Arrays.fill(p, -1);         // -1 means no parent
        Arrays.fill(cost, INF);    // Initialize cost array to INF
        cost[src] = 0;             // Distance from source to itself is 0

        // Run Dijkstra's algorithm
        dijkstra(src);

        // Print the result
        System.out.println("Vertex\tCost\tParent");
        for (int i = 0; i < n; i++) {
            if (cost[i] == INF) {
                System.out.println(i + "\tINF\t" + p[i]);
            } else {
                System.out.println(i + "\t" + cost[i] + "\t" + p[i]);
            }
        }

        sc.close();
    }
}





/*

-1 4 -1 -1 -1 -1 -1 8 -1
4 -1 8 -1 -1 -1 -1 11 -1
-1 8 -1 7 -1 4 -1 -1 2
-1 -1 7 -1 9 14 -1 -1 -1 
-1 -1 -1 9 -1 10 -1 -1 -1 
-1 -1 4 14 10 -1 2 -1 -1
-1 -1 -1 -1 -1 2 -1 1 6
8 11 -1 -1 -1 -1 1 -1 7
-1 -1 2 -1 -1 -1 6 7 -1



source vertex = 0;
*/
