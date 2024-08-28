import java.util.*;

class Fill
{

	public static boolean isSafe(char ch[],int k,int i)
	{
		for(int j=0;j<k;j++)
		{
			if(ch[j]==i)
			{
				return false;
			}
		}
		return true;
	}	
	
	public static void fill(String str,int k,int n,char arr[])
	{
		if(k==n)
		{
			System.out.println(arr);
			return;
		}
		
		
		
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(isSafe(arr,k,ch))
			{
				arr[k]=ch;
				fill(str,k+1,n,arr);
			}
		}
	}
}

class back
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String :");
		String str=sc.nextLine();
		
		char[] ch=str.toCharArray();
		
		Fill f=new Fill();
		
		char[] k=new char[ch.length];
		f.fill(str,0,ch.length,k);
	}
}
