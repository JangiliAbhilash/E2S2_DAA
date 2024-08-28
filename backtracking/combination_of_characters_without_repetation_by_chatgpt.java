import java.util.*;


class check
{	

	void isSafe(String str)
	{
		boolean[] used=new boolean[str.length()];
		char[] ch=str.toCharArray();
		fill(str,ch,used,0);
		
	}
	
	public static void fill(String str,char current[],boolean used[],int index)
	{
		if(index==str.length())
		{
			System.out.println(new String(current));
			return;	
		}
		
		for(int i=0;i<str.length();i++)
		{
			if(!used[i])
			{
				current[index]=str.charAt(i);
				used[i]=true;
				
				fill(str,current,used,index+1);
				
				used[i]=false;
			}
		}
		
	}
}

class combination_of_characters_without_repetation
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String :");
		String str=sc.nextLine();	
		
		char[] ch=str.toCharArray();
		
		check c=new check();
		c.isSafe(str);
		
	}
}
