import java.util.*;

class prac{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Array Size :");
        int n=sc.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter Array Elements :");
            arr[i]=sc.nextInt();
        }

        System.out.println("Enter Element For Search :");
        int ele=sc.nextInt();

        int start=0;
        int last=n-1;
        int mid;

        while(start<=last){
            mid=(start+last)/2;

            if(ele==arr[mid]){
                System.out.println("Element Found at index :"+mid);
                return;
            }
            else if(ele<arr[mid]){
                last=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
    }
}