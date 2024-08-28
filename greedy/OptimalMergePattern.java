import java.util.*;
public class OptimalMergePattern {

    public static int mincost(int[] filesize) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int size : filesize){
            minheap.add(size);
        }
        int totalcost = 0;

        while(minheap.size()>1){
            int file1 = minheap.poll();
            int file2 = minheap.poll();

            int mergecost = file1 + file2;

            totalcost += mergecost;

            minheap.add(mergecost);
        }
        return totalcost;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size Of File :");
        int n = sc.nextInt();

        int filesize[] = new int[n];

        System.out.println("Enter Sizes Of the Files :");
        for(int i=0;i<n;i++)
        {
            filesize[i] = sc.nextInt();
        }

        int res = mincost(filesize);
        System.out.println("Minimum Cost Is :"+res);
    }
    
}


/*

Enter Total Number Of Files:
4
Enter Sizes Of the Files:
4
8
6
12





Enter Total Number Of Files:
5
Enter Sizes Of the Files:
1
2
3
4
5


*/
