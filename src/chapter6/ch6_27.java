package chapter6;

public class ch6_27 {
    public static void main(String[] args) {

        System.out.println("ch2_7 c= new ch27() ");
        ch6_27 c=new ch6_27();


        System.out.println("ch2_7 c2= new ch27() ");
        ch6_27 c2=new ch6_27();



    }
    static {
        System.out.println("static { } ");
    }
    {
        System.out.println("{ } ");
    }
    public ch6_27(){
        System.out.println("생성자");
    }

}
