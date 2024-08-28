#include<stdio.h>
#include<stdlib.h>

void sortedmerge(int arr[], int start, int mid, int last)
{
	int i=start; // first array starting index
	int j=mid+1;  // second array starting indrx
	int k=0;  // temporary array
	int temp[last-start+1]; // number of elements 
	
	while(i<=mid && j<=last)   
	{
		if(arr[i]<arr[j])    // if first array element is small , then it pushes into temporary array
		{
			temp[k++]=arr[i++];
		}
		else         // if Second array element is small , then it pushes into temporary array
		{
			temp[k++]=arr[j++];
		}
	}
	
	while(i<=mid)    // if all elements in second array are moved into temporary , then elemnts remaining in  the first array arey directly push into temproary array
	{
		temp[k++]=arr[i++];
	}
	
	while(j<=last)    // if all elements in first array are moved into temporary , then elemnts remaining in  the second array arey directly push into temproary array
	{
		temp[k++]=arr[j++];
	}
	
	for(i=start,k=0;i<=last;i++,k++)
	{
		arr[i]=temp[k];
	}
	
	return ;
}


void mergesort(int arr[], int start, int last)
{
	if(start<last)
	{
		int mid=(start+last)/2;
		mergesort(arr,start,mid);
		mergesort(arr,mid+1,last);
		
		sortedmerge(arr,start,mid,last);
	}
}

int main()
{
	int n,i;
	printf("Enter Size Of The Array :");
	scanf("%d",&n);
	
	int arr[n];
	
	for(i=0;i<n;i++)
	{
		printf("Enter Array Elements at %d position :",i);
		scanf("%d",&arr[i]);
	}
	
	
	mergesort(arr,0,n-1);
	
	for(i=0;i<n;i++)
	{
		printf("%d ",arr[i]);
	}
}
	
