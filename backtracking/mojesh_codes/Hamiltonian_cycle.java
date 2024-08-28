import java.util.*;

class Hamiltonian_cycle
{
    static int a[]=new int[10];
    static int adj[][]=new int[10][10];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the total number of nodes:");
        n=sc.nextInt();
        System.out.println("Enter the adjacency matrix:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j]=sc.nextInt();
            }
        }
        System.out.println("----------------");
        int k=0;
        fill(n,k);
    }
    public static void fill(int n,int k)
    {
        if(k==n)
        {
           print(a,n);
           return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(k,i,n))
            {
                a[k]=i;
                fill(n,k+1);
            }
        }
    }
    public static boolean isSafe(int k,int i,int n)
    {
        for(int j=0;j<k;j++)
        {
            if(a[j]==i)
            {
                return false;
            }
            if(adj[a[k-1]][i]==0)
            
                return false;
            }
            if(k==n-1 && adj[i][a[0]]==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void print(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
                System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}

