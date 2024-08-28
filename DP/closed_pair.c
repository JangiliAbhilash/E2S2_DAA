#include <stdio.h>
#include <math.h> // Include math.h for sqrt()

struct point
{
    int x;
    int y;
};

int main()
{	
    int n, x1, x2, y1, y2, a, b;
    printf("Enter the total number of points: ");
    scanf("%d", &n);
    struct point p[n];
    
    for (int i = 0; i < n; i++)
    {
        printf("Enter the coordinates of point %d as (x, y): ", (i + 1));
        scanf("%d %d", &p[i].x, &p[i].y);
    }
    
    double min = 9999.0;
    double distance;
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            distance = sqrt(((p[i].x - p[j].x) * (p[i].x - p[j].x)) + ((p[i].y - p[j].y) * (p[i].y - p[j].y)));
            if (distance < min)
            {
                min = distance;
                x1 = p[i].x;
                y1 = p[i].y;
                x2 = p[j].x;
                y2 = p[j].y;
                a = (i + 1);
                b = (j + 1);
            }
        }
    }
    printf("Closest pair was found between the points P%d:(%d, %d) and P%d:(%d, %d) with minimum distance: %.2lf\n", a, x1, y1, b, x2, y2, min);
    return 0;
}

