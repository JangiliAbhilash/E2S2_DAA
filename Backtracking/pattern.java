import java.util.*;

class pattern
{   
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the number of rows:");
        n=sc.nextInt();
        int a[][]=new int[n][n];
        int l=1;
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n-k;i++)
            {
                int j=i+k;
                a[i][j]=l++;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}