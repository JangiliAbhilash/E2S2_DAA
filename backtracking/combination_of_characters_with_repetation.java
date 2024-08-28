import java.util.*;

class Fill
{	
	
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
			
				arr[k]=ch;
				fill(str,k+1,n,arr);
			
		}
	}
}

class combination_of_characters_with_repetation
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
