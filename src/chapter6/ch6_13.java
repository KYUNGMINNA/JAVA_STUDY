package chapter6;


public class ch6_13 {
    public static void main(String[] args) {
        ch6_13 c=new ch6_13();

        int result=c.add(3,5);
        System.out.println(result);

        int[] result2={0};
        c.add(3,5,result2);
        System.out.println(result2[0]);


    }
    int add(int a, int b){
        return a+b;

    }
    void add(int a, int b, int[] result){
        result[0]=a+b;
    }
}
