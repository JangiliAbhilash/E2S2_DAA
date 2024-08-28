#include<stdio.h>
#include<string.h>

int main()
{
    int i,j;
    char str1[100],str2[100];
    
    int flag=0,c=0,flag1;
    printf("Enter First String :");
    scanf("%s",&str1);
    printf("Enter Second String :");
    scanf("%s",&str2);
    int l1=strlen(str1);
    int l2=strlen(str2);
    
    for(i=0;i<l1;i++)
    {
    	if(str2[0]==str1[i])
    	{
    		
    		flag1=0;
    		for(j=0;j<l2;j++)
    		{
    			if(str2[j]!=str1[j+1])
    			{
    				c++;
    				flag1=1;
    				break;
    			}
    		}
    		
    		if(flag==0)
    		{
    			printf("Match Found At Index %d to Index %d \n",i,(i+l2-1));
    			c++;
    			break;
    			
    		}
    		
    	}
    }
    
    if(flag1!=1)
    {
    	printf("Match Not Found ");
    }
    
    printf("Count=%d",c);		
}
