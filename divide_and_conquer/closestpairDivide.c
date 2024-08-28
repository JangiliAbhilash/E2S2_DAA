#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <float.h>

// Define a Point structure
typedef struct {
    int x, y;
} Point;

// Function to calculate the distance between two points
double distance(Point p1, Point p2) {
    return sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
}

// Function to compare two points by their x-coordinate (for sorting)
int compareX(const void* a, const void* b) {
    Point* p1 = (Point*)a;
    Point* p2 = (Point*)b;
    return p1->x - p2->x;
}

// Function to compare two points by their y-coordinate (for sorting)
int compareY(const void* a, const void* b) {
    Point* p1 = (Point*)a;
    Point* p2 = (Point*)b;
    return p1->y - p2->y;
}

// A utility function to find the minimum of two double values
double min(double x, double y) {
    return (x < y) ? x : y;
}

// Function to find the closest distance by brute force (used when the number of points is small)
double bruteForce(Point P[], int n) {
    double min = DBL_MAX;
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

// A utility function to find the distance between the closest points in a strip of given size
double stripClosest(Point strip[], int size, double d) {
    double min = d;  // Initialize the minimum distance as d

    qsort(strip, size, sizeof(Point), compareY);  // Sort the points according to y-coordinate

    for (int i = 0; i < size; ++i) {
        for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; ++j) {
            double dist = distance(strip[i], strip[j]);
            if (dist < min) {
                min = dist;
            }
        }
    }

    return min;
}

// Recursive function to find the smallest distance
double closestUtil(Point P[], int n) {
    // Base case: if there are 3 or fewer points, use brute-force approach
    if (n <= 3) {
        return bruteForce(P, n);
    }

    // Find the middle point
    int mid = n / 2;
    Point midPoint = P[mid];

    // Recursively find the smallest distance in the left and right halves
    double dl = closestUtil(P, mid);
    double dr = closestUtil(P + mid, n - mid);

    // Find the smaller of the two distances
    double d = min(dl, dr);

    // Build an array strip[] that contains points close to the line dividing the two halves
    Point* strip = (Point*)malloc(n * sizeof(Point));
    int j = 0;
    for (int i = 0; i < n; i++) {
        if (abs(P[i].x - midPoint.x) < d) {
            strip[j] = P[i];
            j++;
        }
    }

    // Find the closest points in strip. Return the minimum of d and stripClosest
    double minDist = stripClosest(strip, j, d);
    free(strip);
    return minDist;
}

// Main function to find the smallest distance among the points
double closest(Point P[], int n) {
    qsort(P, n, sizeof(Point), compareX);  // Sort points according to x-coordinate
    return closestUtil(P, n);
}

int main() {
    int n;
    printf("Enter the number of points: ");
    scanf("%d", &n);

    Point* P = (Point*)malloc(n * sizeof(Point));
    printf("Enter the points (x y):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &P[i].x, &P[i].y);
    }

    double result = closest(P, n);
    printf("The smallest distance is %.6f\n", result);

    free(P);
    return 0;
}

