import java.util.*;

class Fill
{

	public static void fill(int arr[],int n,int k)
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
				fill(arr,n,k+1);
		}
	}
}

class print_binary
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number Of Elements You Need :");
		int n=sc.nextInt();
		int arr[]=new int[n];
		
		Fill f=new Fill();
		f.fill(arr,n,0);
	}
}
