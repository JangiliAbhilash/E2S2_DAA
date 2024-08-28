import java.util.Scanner;

public class MatrixChainMultiplication {

    // Function to find the most efficient way to multiply matrices
    public static int matrixChainOrder(int[] p, int n) {
        int[][] m = new int[n][n];

        // m[i, j] = Minimum number of scalar multiplications needed to compute the matrix A[i]A[i+1]...A[j] = A[i..j]
        // The cost is zero when multiplying one matrix.
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    // q = cost/scalar multiplications
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of matrices: ");
        int numMatrices = scanner.nextInt();

        int[] dimensions = new int[numMatrices];
        System.out.println("Enter the dimensions of the matrices:");
        for (int i = 0; i < numMatrices; i++) {
            System.out.print("Dimension " + i + ": ");
            dimensions[i] = scanner.nextInt();
        }

        int size = dimensions.length;

        int result = matrixChainOrder(dimensions, size);
        System.out.println("Minimum number of multiplications is " + result);
    }
}

