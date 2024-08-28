#include <stdio.h>
#include <stdlib.h>

// Structure to represent a point in 2D space
struct Point {
    int x, y;
};

// Function to find the orientation of three points (p, q, r)
// Returns 0 if p, q, r are collinear
// Returns 1 if they are clockwise
// Returns 2 if they are counterclockwise
int orientation(struct Point p, struct Point q, struct Point r) {
    int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    if (val == 0) return 0; // collinear
    return (val > 0) ? 1 : 2; // clockwise or counterclockwise
}

// Function to swap two points
void swap(struct Point* p1, struct Point* p2) {
    struct Point temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

// Function to find the square of the distance between two points
int distSq(struct Point p1, struct Point p2) {
    return (p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y);
}

// Function to perform sorting of points based on polar angle
int compare(const void *vp1, const void *vp2) {
    struct Point *p1 = (struct Point *)vp1;
    struct Point *p2 = (struct Point *)vp2;

    // Find orientation
    int o = orientation(p0, *p1, *p2);
    if (o == 0)
        return (distSq(p0, *p2) >= distSq(p0, *p1)) ? -1 : 1;

    return (o == 2) ? -1 : 1;
}

// Function to find the convex hull of a set of points
void convexHull(struct Point points[], int n) {
    // Find the bottommost point (with the smallest y-coordinate)
    int ymin = points[0].y, min = 0;
    for (int i = 1; i < n; i++) {
        int y = points[i].y;

        // Pick the bottom-most or chose the left most point in case of tie
        if ((y < ymin) || (ymin == y && points[i].x < points[min].x))
            ymin = points[i].y, min = i;
    }

    // Place the bottom-most point at first position
    swap(&points[0], &points[min]);

    // Sort remaining points based on their polar angle in counterclockwise order from the first point
    *p0 = points[0];
    qsort(&points[1], n - 1, sizeof(struct Point), compare);

    // Initialize result stack
    int m = 1; // Initialize size of modified array
    for (int i = 1; i < n; i++) {
        // Keep removing i while angle of i and i+1 is same with respect to p0
        while (i < n - 1 && orientation(p0, points[i], points[i + 1]) == 0)
            i++;

        points[m] = points[i];
        m++; // Update size of modified array
    }

    // If modified array of points has less than 3 points, convex hull is not possible
    if (m < 3) return;

    // Create an empty stack and push first three points to it
    int stack[m];
    int top = 2;
    stack[0] = 0;
    stack[1] = 1;
    stack[2] = 2;

    // Process remaining points
    for (int i = 3; i < m; i++) {
        // Keep removing top while the angle formed by points next-to-top, top, and points[i] makes a non-left turn
        while (top > 0 && orientation(points[stack[top - 1]], points[stack[top]], points[i]) != 2)
            top--;

        stack[++top] = i; // Add points[i] to the stack
    }

    // Print convex hull points
    printf("Convex Hull:\n");
    for (int i = 0; i <= top; i++)
        printf("(%d, %d)\n", points[stack[i]].x, points[stack[i]].y);
}

// Driver program to test above functions
int main() {
    struct Point points[] = {{0, 3}, {1, 1}, {2, 2}, {4, 4}, {0, 0}, {1, 2}, {3, 1}, {3, 3}};
    int n = sizeof(points) / sizeof(points[0]);
    convexHull(points, n);
    return 0;
}

