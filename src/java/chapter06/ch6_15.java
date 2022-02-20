package java.chapter06;

public class ch6_15 {
    public static void main(String[] args) {
        System.out.println(factorial(4));

    }
    static int factorial(int n){
        int result=0;

        if( n==1){
            return 1;
        }else{
            result=n*factorial(n-1);
        }
        return result;
    }
}
