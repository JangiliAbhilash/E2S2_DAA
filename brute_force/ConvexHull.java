import java.util.ArrayList;
import java.util.List;
public class ConvexHull {

  public static void main(String[] args) {

    List<Point> points = new ArrayList<>();
    points.add(new Point(0, 0));
    points.add(new Point(0, 4));
    points.add(new Point(-4, 0));
    points.add(new Point(5, 0));
    points.add(new Point(0, -6));
    points.add(new Point(1, 0));
    
    /*
    points.add(new Point(1, 1));
    points.add(new Point(-1, -1));
    points.add(new Point(1, -1));
    points.add(new Point(-1, 1));
    points.add(new Point(0, 0));
    */

    List<Point> convexHull = convexHullBF(points);

    System.out.println("Convex Hull Points are:");
    for (Point p : convexHull) {
      System.out.println("(" + p.x + " , " + p.y + ")");
    }
  }

  private static List<Point> convexHullBF(List<Point> points) {

    List<Point> hull = new ArrayList<>();

    if (points.size() <= 3) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        hull.add(p1);
        hull.add(p2);
        hull.add(p3);
      return hull;
    }

    for (int i = 0; i < points.size(); i++) {
      for (int j = 0; j < points.size(); j++) {
        if (i == j) {
          continue;
        }

        Point p1 = points.get(i);
        Point p2 = points.get(j);

        boolean valid = check(points, p1, p2);

        if (valid) {
          if (!hull.contains(p1)) {
            hull.add(p1);
          }
          if (!hull.contains(p2)) {
            hull.add(p2);
          }
        }
      }
    }

    return hull;
  }

  private static boolean check(List<Point> points, Point p1, Point p2) {

    double a = p1.y - p2.y;
    double b = p2.x - p1.x;
    double c = p2.x * p1.y - p1.x * p2.y;

    int pcount = 0;
    int ncount = 0;

    for (int k = 0; k < points.size(); k++) {
      Point p = points.get(k);
      double val = a * p.x + b * p.y - c;
      if (val > 0) {
        pcount++;
      } else if (val < 0) {
        ncount++;
      }
    }
    if(pcount == 0 || ncount == 0)
    	return true;
	else
		return false;
  }

  public static class Point {
    public final double x;
    public final double y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }
}
