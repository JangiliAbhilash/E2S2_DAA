import java.util.*;

class prac {
    public static int fibo(int n) {

            if(n==0){
                return 0;
            }
            if(n==1){
                return 1;
            }
            else
            {
                return fibo(n-1)+fibo(n-2);
            }
        
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number :");
        int n = sc.nextInt();

      
        int res = fibo(n);
        System.out.println("Fibonacci Sequence Value at Position " + n + " is: " + res);
    }
}

