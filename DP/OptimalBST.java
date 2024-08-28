import java.util.Scanner;

public class OptimalBST {

    // Function to calculate the cost of the optimal binary search tree
    public static int optimalBST(int[] keys, int[] freq, int n) {
        int[][] cost = new int[n + 1][n + 1];

        // For a single key, cost is equal to frequency
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // L is chain length
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try making all keys in interval keys[i..j] as root
                for (int k = i; k <= j; k++) {
                    int c = ((k > i) ? cost[i][k - 1] : 0) + ((k < j) ? cost[k + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        return cost[0][n - 1];
    }

    // Utility function to sum frequencies from i to j
    private static int sum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of keys: ");
        int n = scanner.nextInt();

        int[] keys = new int[n];
        int[] freq = new int[n];

        System.out.println("Enter the keys:");
        for (int i = 0; i < n; i++) {
            System.out.print("Key " + (i + 1) + ": ");
            keys[i] = scanner.nextInt();
        }

        System.out.println("Enter the frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Frequency of key " + keys[i] + ": ");
            freq[i] = scanner.nextInt();
        }

        int cost = optimalBST(keys, freq, n);
        System.out.println("Minimum Cost of the Optimal Binary Search Tree is: " + cost);
    }
}

