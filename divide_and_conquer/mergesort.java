import java.util.*;

public class mergesort {

    public static void sortedmerge(int arr[],int start,int mid,int last){
        int i=start; // first array starting index
        int j=mid+1; // second array starting index
        int k=0; 
        int temp[]=new int[last-start+1]; // temp array

        while(i<=mid && j<=last){
            if(arr[i]<arr[j]){ // if first array element is small, then it pushes into temp array.
                temp[k++]=arr[i++];
            }
            else{ //if Second array element is small , then it pushes into temporary array
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){  // if all elements in second array are moved into temporary , then elemnts remaining in  the first array arey directly push into temproary array
            temp[k++]=arr[i++];
        }
        while(j<=last){  // if all elements in first array are moved into temporary , then elemnts remaining in  the second array arey directly push into temproary array
            temp[k++]=arr[j++];
        }

        for(i=start,k=0;i<=last;i++,k++){
            arr[i]=temp[k];
        }
        return;
    }

    public static void MergeSort(int arr[],int start,int last) {
        if(start<last){
            int mid=(start+last)/2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid+1, last);

            sortedmerge(arr, start, mid, last);
        }
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            System.out.println("Enter elements :");
            arr[i]=sc.nextInt();
        }
        MergeSort(arr, 0, n-1);

        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
