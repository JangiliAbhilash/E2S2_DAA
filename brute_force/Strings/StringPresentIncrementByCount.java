import java.util.*;

public class StringPresentIncrementByCount {


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Main String :");
        String str1=sc.nextLine();
        System.out.println("Enter Sub String :");
        String str2=sc.nextLine();
        
        int flag=0,flag1=1,count=0,k=0,k1=0;

        for(int i=0;i<str1.length();i++){
            if(str2.charAt(0)==str1.charAt(i));{
                flag1=0;
                k=i;
                k1=0;
                for(int j=0;j<str2.length();j++){
                    k=k+k1;
                    if(str2.charAt(j)!=str1.charAt(j+k)){
                        flag1=1;
                        break;
                    }
                    else{
                        k1++;
                    }
                }
                if(flag1==0){
                    System.out.println("String Matched at Index :"+i);
                    flag=1;
                    count++;
                }
            }
        }

        if(flag==1){
            System.out.println("Match Found :");
        }
        else{
            System.out.println("Match Not Found :");
        }
        System.out.println("String Occured By "+count+" Times");
    }
}