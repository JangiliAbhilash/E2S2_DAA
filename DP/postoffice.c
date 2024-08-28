#include <stdio.h> 

struct print
{
	int x;
	int y;
};

int main()
{	
	int n,x,y,point;
	printf("Enter the total number of points:");
	scanf("%d",&n);
	struct print p[n];
	for(int i=0;i<n;i++)
	{
		printf("Enter the coordinates of point %d as (x,y):",(i+1));
		scanf("%d%d",&p[i].x,&p[i].y);
	}
	int min_avg=9999;
	int distance;
	for(int i=0;i<n-1;i++)
	{
		int sum=0;
		for(int j=0;j<n;j++)
		{
			distance=((p[i].x-p[j].x)*(p[i].x-p[j].x))+((p[i].y-p[j].y)*(p[i].y-p[j].y));
			sum=sum+distance;
		}
		int avg=(sum)/(n-1);
		if(avg<min_avg)
		{
			min_avg=avg;
			x=p[i].x;
			y=p[i].y;
			point=(i+1);
		}
	}
	printf("The postoffice can be built at point %d wchich has coordinates as (%d,%d)\n",point,x,y);
}
		
