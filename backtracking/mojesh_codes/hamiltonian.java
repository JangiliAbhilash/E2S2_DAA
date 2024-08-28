import java.util.*;

class Hamiltonian_cycle
{
    static int a[]=new int[10];
    static int adj[][]=new int[10][10];
    static boolean foundCycle = false; // Variable to track if cycle is found
    
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
        System.out.println("Enter the starting node:");
        int startNode = sc.nextInt();
        System.out.println("----------------");
        int k=0;
        a[0] = startNode; // Set the starting node
        fill(n,k,startNode);
        if (!foundCycle) {
            System.out.println("No Hamiltonian cycle found starting from node " + startNode);
        }
    }
    public static void fill(int n,int k, int startNode)
    {
        if(k==n && adj[a[k-1]][startNode] == 1)
        {
            foundCycle = true;
            print(a,n);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(k,i,n))
            {
                a[k]=i;
                fill(n,k+1,startNode);
                a[k]=-1; // Backtrack
            }
        }
    }
    public static boolean isSafe(int k,int i,int n)
    {
        if (k == 0 || adj[a[k-1]][i] == 1) {
            for(int j=0;j<k;j++)
            {
                if(a[j]==i)
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static void print(int a[],int n)
    {
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.print(a[0]); // Print the starting node again to complete the cycle
        System.out.println();
    }
}
