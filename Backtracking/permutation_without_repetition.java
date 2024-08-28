import java.util.*;

class permutation_without_repetition
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the size of String:");
        n=sc.nextInt();
        String str;
        System.out.println("Enter String:");
        str=sc.next();
        int k=0;
        char arr[]=new char[n];
        System.out.println("---------------");
        fill(k,n,str,arr);
    }

    public static void fill(int k,int n,String str,char arr[])
    {
        if(k==n)
        {
            System.out.println(arr);
            return;
        }
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            if(isSafe(k,arr,ch))
            {
                arr[k]=ch; 
                fill(k+1,n,str,arr);
            }
        }
    }
    public static boolean isSafe(int k,char arr[],char ch)
    {
        for(int i=0;i<k;i++)
        {
            if(arr[i]==ch)
            {
                return false;
            }
        }
        return true;
    }
}


