import java.util.Scanner;
import java.util.Arrays;

public class Dijkstra {

    // Function to find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree
    
    static int minDistance(int[] dist, boolean[] set, int V) {
    
        // Initialize min value
        
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!set[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to implement Dijkstra's algorithm for a graph represented using adjacency matrix representation
    
    static void dijkstra(int[][] graph, int src, int V) {
    
        int[] dist = new int[V]; // The output array. dist[i] will hold the shortest distance from src to i
        
        
        boolean[] set = new boolean[V]; // set[i] will be true if vertex i is included in shortest path tree

        // Initialize all distances as INFINITE and stpSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(set, false);


        // Distance of source vertex from itself is always 0
        dist[src] = 0;
        

        // Find shortest path for all vertices
        
        for (int count = 0; count < V - 1; count++) {
        
            // Pick the minimum distance vertex from the set of vertices not yet processed
            int u = minDistance(dist, set, V);


            // Mark the picked vertex as processed
            set[u] = true;


            // Update dist value of the adjacent vertices of the picked vertex

            for (int v = 0; v < V; v++) {
                // Update dist[v] only if is not in set, there is an edge from u to v, and total weight of path from src to v through u is smaller than current value of dist[v]

                if (!set[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, V);
    }

    // Function to print the constructed distance array
    static void printSolution(int[] dist, int V) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int[][] graph = new int[V][V];

        System.out.println("Enter the adjacency matrix (enter 0 if there is no direct edge between vertices): ");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the source vertex: ");
        int src = scanner.nextInt();

        dijkstra(graph, src, V);
    }
}





/*

Enter the number of vertices: 5
Enter the adjacency matrix (enter 0 if there is no direct edge between vertices):
0 10 0 30 100
10 0 50 0 0
0 50 0 20 10
30 0 20 0 60
100 0 10 60 0
Enter the source vertex: 0
Vertex 		 Distance from Source
0 		 0
1 		 10
2 		 50
3 		 30
4 		 60



*/










import java.util.Scanner;
import java.util.Arrays;

public class Dijkstra {

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
