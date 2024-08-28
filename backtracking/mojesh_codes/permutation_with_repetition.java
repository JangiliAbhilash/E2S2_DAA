import java.util.*;

class permutation_with_repetition
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str;
        System.out.println("Enter String:");
        str=sc.next();
        int k=0;
        char arr[]=new char[str.length()];
        System.out.println("---------------");
        fill(k,str.length(),str,arr);
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
            arr[k]=ch;
            fill(k+1,n,str,arr);
        }
    }
}

