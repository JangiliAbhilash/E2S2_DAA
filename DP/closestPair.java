public class closestPair {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point[] points = {
            new Point(2, 3), new Point(12, 30), new Point(40, 50),
            new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        Point[] closestPair = findClosestPair(points);
        System.out.println("Closest pair: (" + closestPair[0].x + ", " + closestPair[0].y + 
                            ") and (" + closestPair[1].x + ", " + closestPair[1].y + ")");
    }

    public static Point[] findClosestPair(Point[] points) {
        int n = points.length;
        if (n < 2) return null;

        Point[] closestPair = new Point[2];
        double minDist = Double.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = dist(points[i], points[j]);
                if (distance < minDist) {
                    minDist = distance;
                    closestPair[0] = points[i];
                    closestPair[1] = points[j];
                }
            }
        }
        return closestPair;
    }

    private static double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}

