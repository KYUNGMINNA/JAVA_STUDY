package chapter09;

import java.util.*;
import static java.util.Objects.*;
public class ch9_26 {
    public static void main(String[] args) {
        String[][] str2D=new String[][]{{"aaa","bbb"},{"AAA","BBB"}};
        String[][] str2D_2=new String[][]{{"aaa","bbb"},{"AAA","BBB"}};

        System.out.print("str2D  = {");
        for(String[] tmp:str2D){
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");

        System.out.print("str2D_2  = {");
        for(String[] tmp:str2D_2){
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");

        //import static java.util.Objects.*;를 사용했어도 , Object클래스의 메서드와 이름이 같은것들은 컴파일러가 구별을 못해 클래스이름(Objects) 을 붙여줘야한다.
        System.out.println("eqauls(str2D,str2D_2) : "+Objects.equals(str2D,str2D_2));
        System.out.println("deepEqauls(str2D,str2D_2) :"+Objects.deepEquals(str2D,str2D_2));

        System.out.println("isNull(null) :"+isNull(null));
        System.out.println("Objects.isNull(null) :"+Objects.isNull(null));

        System.out.println("nonNull(null) :"+nonNull(null));
        System.out.println("Objects.nonNull(null) :"+Objects.nonNull(null));

        System.out.println("hasoCOde(null) : "+Objects.hashCode(null));
        System.out.println("toString(null) : "+Objects.toString(null));
        System.out.println("toString(null,\"\") : "+Objects.toString(null,""));

        //String 클래스에 상수로 정의되어있는 Comparator
        Comparator c=String.CASE_INSENSITIVE_ORDER; //대소문자 비교안함

        System.out.println("compare(\"aa\",\"bb\")="+compare("aa","bb",c));
        System.out.println("compare(\"bb\",\"aa\")="+compare("bb","aa",c));
        System.out.println("compare(\"ab\",\"AB\")="+compare("ab","AB",c));



    }
}
