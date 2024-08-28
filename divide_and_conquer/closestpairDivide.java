import java.util.Arrays;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class closestpairDivide {

    // Function to calculate the distance between two points
    static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    // Main function to find the smallest distance
    static double closest(Point[] P, int n) {
        // Base case: if there are 3 or fewer points, find the smallest distance by checking all pairs
        if (n <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    double dist = distance(P[i], P[j]);
                    if (dist < min) {
                        min = dist;
                    }
                }
            }
            return min;
        }

        // Find the middle point
        int mid = n / 2;
        Point midPoint = P[mid];

        // Recursively find the smallest distance in the left and right halves
        double dl = closest(Arrays.copyOfRange(P, 0, mid), mid);
        double dr = closest(Arrays.copyOfRange(P, mid, n), n - mid);

        // Find the smaller of the two distances
        double d = Math.min(dl, dr);

        // Create an array to hold points that are within distance 'd' from the middle line
        Point[] strip = new Point[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(P[i].x - midPoint.x) < d) {
                strip[j] = P[i];
                j++;
            }
        }

        // Sort the strip array according to the y-coordinate
        
        Arrays.sort(strip, 0, j, (p1, p2) -> p1.y - p2.y);

        // Find the closest points in the strip
        	
        for (int i = 0; i < j; ++i) {
            for (int k = i + 1; k < j && (strip[k].y - strip[i].y) < d; ++k) {
                double dist = distance(strip[i], strip[k]);
                if (dist < d) {
                    d = dist;
                }
            }
        }

        return d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        Point[] P = new Point[n];
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            P[i] = new Point(x, y);
        }

        // Sort the points according to the x-coordinate
        Arrays.sort(P, (p1, p2) -> p1.x - p2.x);

        // Find the smallest distance among the points
        double result = closest(P, n);
        System.out.printf("The smallest distance is %.6f\n", result);

        scanner.close();
    }
}

