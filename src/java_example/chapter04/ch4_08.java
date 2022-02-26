package java_example.chapter04;

import java.util.*;
public class ch4_08 {
    public static void main(String[] args) {
        System.out.printf("당신의 주민번호를 입력하세요 (111111-1111111) >>>");
        Scanner scanner=new Scanner(System.in);
        String reg=scanner.nextLine();

        char gen=reg.charAt(7);

        switch (gen){
            case '1': case '3':
                System.out.printf("남자");
                break;
            case '2': case '4':
                System.out.printf("여자");
                break;
            default:
                System.out.printf("유효하지 않음");
        }
    }

}
