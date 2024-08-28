import java.util.*;

class ClosestPair {

    // Function to calculate the distance between two points
    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Function to find the closest pair of points using brute force
    static double closestPairBruteForce(Point[] points) {
        int n = points.length;
        double minDist = Double.POSITIVE_INFINITY;

        // Iterate through all pairs of points and find the minimum distance
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                }
            }
        }

        return minDist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of points
        System.out.print("Enter the number of points: ");
        int n = scanner.nextInt();

        // Input the points
        Point[] points = new Point[n];
        System.out.println("Enter the points (x y):");
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        // Find the closest pair of points using brute force
        double minDistance = closestPairBruteForce(points);
        System.out.println("The smallest distance is: " + minDistance);

        scanner.close();
    }

    // Point class to represent a point in 2D space
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
