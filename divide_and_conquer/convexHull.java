import java.util.*;

public class convexHull {
	static class Point {
		double x, y;
	        Point(double x, double y) {
			this.x = x;
			this.y = y;
	        }
  	}
	  	
   	public static int orientation(Point p, Point q, Point r) {
       	double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        	if (val == 0)
        		return 0; 
        	return (val > 0) ? 1 : 2; 
    	}
    	
	public static Point[ ] convexHull(Point points[ ]) {
		int n = points.length;
	        if (n < 3) {
	        	return null; 
	        }
		Point hull[ ]= new Point[2 * n]; 
	       int hullSize = 0;
		       	
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
		      		boolean isHullEdge = true;
					for (int k = 0; k < n; k++) {
						if (k == i || k == j)
							continue;
						int orient = orientation(points[i], points[j], points[k]);
						if (orient == 2) {
			    				isHullEdge = false;
			   				break;
						}
		      			}
			     		if (isHullEdge) {
						boolean pointIExists = false;
			         		boolean pointJExists = false;
						for (int h = 0; h < hullSize; h++) {
				   			if (hull[h] == points[i])
					   		pointIExists = true;
					    		if (hull[h] == points[j])
					    			pointJExists = true;
				         	}
						if (!pointIExists)
							hull[hullSize++] = points[i];
						if (!pointJExists)
							hull[hullSize++] = points[j];
			      		}
			  }
		}
		return Arrays.copyOf(hull, hullSize);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int n = scanner.nextInt();

		Point[] points = new Point[n];
		System.out.println("Enter the points (x y):");
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			points[i] = new Point(x, y);
		}

	        Point hull[ ]= convexHull(points);
		if (hull != null) {
			System.out.println("Convex Hull points:");
		  	for (Point p : hull) {
		      		System.out.printf("(%.1f, %.1f)\n", p.x, p.y);
		  	}
	        }
	        else {
			System.out.println("Convex hull not possible");
	        }
	}
}

