#include <stdio.h>
#include <stdlib.h>

typedef struct {
    double x, y;
} Point;

int orientation(Point p, Point q, Point r) {
    double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    if (val == 0)
        return 0; // collinear
    return (val > 0) ? 1 : 2; // 1 -> clockwise, 2 -> counterclockwise
}

Point* convexHull(Point points[], int n, int* hullSize) {
    if (n < 3) {
        *hullSize = 0;
        return NULL; // Convex hull not possible
    }

    Point* hull = (Point*)malloc(2 * n * sizeof(Point));
    *hullSize = 0;

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            int isHullEdge = 1;

            for (int k = 0; k < n; k++) {
                if (k == i || k == j)
                    continue;

                int orient = orientation(points[i], points[j], points[k]);
                if (orient == 2) { // Counterclockwise
                    isHullEdge = 0;
                    break;
                }
            }

            if (isHullEdge) {
                int pointIExists = 0;
                int pointJExists = 0;

                for (int h = 0; h < *hullSize; h++) {
                    if (hull[h].x == points[i].x && hull[h].y == points[i].y)
                        pointIExists = 1;
                    if (hull[h].x == points[j].x && hull[h].y == points[j].y)
                        pointJExists = 1;
                }

                if (!pointIExists)
                    hull[(*hullSize)++] = points[i];
                if (!pointJExists)
                    hull[(*hullSize)++] = points[j];
            }
        }
    }

    return hull;
}

int main() {
    int n;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    Point* points = (Point*)malloc(n * sizeof(Point));
    printf("Enter the points (x y):\n");
    for (int i = 0; i < n; i++) {
        scanf("%lf %lf", &points[i].x, &points[i].y);
    }

    int hullSize;
    Point* hull = convexHull(points, n, &hullSize);

    if (hullSize > 0) {
        printf("Convex Hull points:\n");
        for (int i = 0; i < hullSize; i++) {
            printf("(%.1f, %.1f)\n", hull[i].x, hull[i].y);
        }
        free(hull);
    } else {
        printf("Convex hull not possible\n");
    }

    free(points);
    return 0;
}

