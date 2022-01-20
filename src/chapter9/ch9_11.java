package chapter9;

public class ch9_11 {
    public static void main(String[] args) {

        //문자열 리터럴 str=" "은 str1과 str2가 같은 객체의 를 가리키고 있음(같은 주소를 갖음)


        String str1="abc";
        String str2="abc";

        System.out.println("str1="+str1);
        System.out.println("str1="+str2);

        System.out.println("str1==str2 :"+(str1==str2));
        System.out.println("str1.equals(str2) :"+str1.equals(str2));

        //String 인스턴스 ==nwe String(" " );는  각 참조변수마다 객체를 가지고 있어 고유의 주소를 갖음.


        String str3=new String("abc");
        String str4=new String("abc");

        System.out.println("str3"+str3);
        System.out.println("str4"+str4);

        System.out.println("str3==str4"+str3==str4);
        System.out.println("str3.equals(str4)"+str3.equals(str4));

    }
}
