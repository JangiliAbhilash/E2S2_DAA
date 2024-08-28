#include<stdio.h>

void swap(int *a,int *b)
{
	int temp=*a;
	*a=*b;
	*b=temp;
}

int partion(int arr[],int start,int end)
{
	int pivot=arr[end];
	int i=0,pindex=0;   // pindex=pivot index
	
	for(i=0;i<end;i++)
	{
		if(arr[i]<=pivot)
		{
			swap(&arr[i],&arr[pindex]);
			pindex++;
		}
	}
	swap(&arr[end],&arr[pindex]);
	return pindex;
}

void quicksort(int arr[],int start,int end)
{
	if(start<end)
	{
		int pindex=partion(arr,start,end);
		
		quicksort(arr,start,pindex-1);
		quicksort(arr,pindex+1,end);
		
	}
}

int main()
{
	int n,i;
	printf("Enter Array Size :");
	scanf("%d",&n);
	
	int arr[n];
	
	for(i=0;i<n;i++)
	{
		printf("Enter Array Elment At %d Position :",i);
		scanf("%d",&arr[i]);
	}
	
	quicksort(arr,0,n-1);
	
	for(i=0;i<n;i++)
	{
		printf("%d ",arr[i]);
	}
}
