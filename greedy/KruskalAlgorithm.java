import java.util.Scanner;
import java.util.Arrays;

public class KruskalAlgorithm {

    static final int MAX = 100;
    static final int INF = Integer.MAX_VALUE;
    static int[][] adj = new int[MAX][MAX];
    static int[] parent = new int[MAX];

    // Function to find the edge with the minimum weight
    static void findMinEdge(int n, int[] edge) {
        int min = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] < min && adj[i][j] != -1) {
                    min = adj[i][j];
                    edge[0] = i;
                    edge[1] = j;
                }
            }
        }
    }

    // Function to find the parent of a node using path compression
    static int findParent(int k) {
        if (k != parent[k]) {
            parent[k] = findParent(parent[k]);
        }
        return parent[k];
    }

    // Function to check if adding an edge creates a loop
    static boolean checkLoop(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return false;
        parent[pv] = pu;
        return true;
    }

    // Kruskal's algorithm implementation
    static void kruskal(int n) {
        int k = n - 1; // number of edges to be added
        int min_cost = 0;
        int[] edge = new int[2];
        while (k > 0) {
            findMinEdge(n, edge);
            int u = edge[0];
            int v = edge[1];

            if (checkLoop(u, v)) {
                System.out.println("Edge: " + u + " - " + v);
                min_cost += adj[u][v];
             
                k--;
                
            }
            adj[u][v] = adj[v][u] = -1; // mark edge as used
        }
        System.out.println("Minimum Cost Is "+min_cost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize adjacency matrix to -1 (indicating no edges)
        for (int i = 0; i < MAX; i++) {
            Arrays.fill(adj[i], -1);
        }

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter the edges (u, v) and their weights:");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj[u][v] = adj[v][u] = w;
        }

        // Initialize parent array for union-find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        System.out.println("The edges in the Minimum Spanning Tree are:");
        kruskal(n);

        sc.close();
    }
}




/*

Enter the number of vertices: 4
Enter the number of edges: 5
Enter the edges (u, v) and their weights:
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4


The edges in the Minimum Spanning Tree are:
Edge: 2 - 3
Edge: 0 - 3
Edge: 0 - 1








Enter the number of vertices: 3
Enter the number of edges: 3
Enter the edges (u, v) and their weights:
0 1 1
1 2 2
0 2 3


The edges in the Minimum Spanning Tree are:
Edge: 0 - 1
Edge: 1 - 2



*/
