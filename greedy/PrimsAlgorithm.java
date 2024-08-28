import java.util.Arrays;
import java.util.Scanner;

public class PrimsAlgorithm {

    public void Prim(int G[][], int V) {
        int INF = 9999999;

        int no_edge; // number of edges

        // create an array to track selected vertex
        // selected will become true otherwise false
        boolean[] selected = new boolean[V];

        // set selected false initially
        Arrays.fill(selected, false);

        // set number of edges to 0
        no_edge = 0;

        // the number of edges in minimum spanning tree will be
        // always less than (V -1), where V is the number of vertices in
        // the graph

        // choose the 0th vertex and make it true
        selected[0] = true;

        // print for edge and weight
        System.out.println("Edge : Weight");

        while (no_edge < V - 1) {
            // For every vertex in the set S, find all adjacent vertices
            // , calculate the distance from the vertex selected at step 1.
            // if the vertex is already in the set S, discard it otherwise
            // choose another vertex nearest to the selected vertex at step 1.

            int min = INF;
            int x = 0; // row number
            int y = 0; // col number

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + G[x][y]);
            selected[y] = true;
            no_edge++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        PrimsAlgorithm g = new PrimsAlgorithm();

        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        int[][] G = new int[V][V];

        System.out.println("Enter the adjacency matrix (0 for no edge):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                G[i][j] = sc.nextInt();
            }
        }

        g.Prim(G, V);

        sc.close();
    }
}

