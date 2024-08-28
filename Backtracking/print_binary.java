import java.util.*;

class print_binary
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number:");
        int n=sc.nextInt();
        int k=0;
        int arr[]=new int[n];
        System.out.println("---------------");
        fill(k,n,arr);
    }

    public static void fill(int k,int n,int arr[])
    {
        if(k==n)
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<=1;i++)
        {
            arr[k]=i;
            fill(k+1,n,arr);
        }
    }
}

