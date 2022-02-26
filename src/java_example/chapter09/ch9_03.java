package java_example.chapter09;

public class ch9_03 {
    public static void main(String[] args) {
        String str1=new String("abc");
        String str2=new String("abc");

        System.out.println(str1.equals(str2));
        //String 클래스는 문자열의 내용이 같으면 동일한 해시코드를 반환
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        //System.indentityHascode()는 객체의 주소로 값으로 생성해서 객체에 대해 항상 다른 해시값 갖음
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));


        String a="abc";
        String b="abc";
        System.out.println("a:"+a+"   b:"+b);
        System.out.println("hashCode()");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println("identityHashCode()");
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

    }

}
