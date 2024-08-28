import java.util.*;

public class StringMatchIncrementBy1 {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Main String :");
        String str1=sc.nextLine();
        System.out.println("Enter Sub String :");
        String str2=sc.nextLine();
        int flag=0,flag1=1,count=0;
        for(int i=0;i<str1.length();i++){
            if(str2.charAt(0)==str1.charAt(i)){
                flag1=0;
                for(int j=0;j<str2.length();j++){
                    if(str2.charAt(j)!=str1.charAt(i+j*2)){
                        flag1=1;
                        break;
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
