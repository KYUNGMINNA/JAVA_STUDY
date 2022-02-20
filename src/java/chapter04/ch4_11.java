package java.chapter04;

import java.util.*;
public class ch4_11 {
    public static void main(String[] args) {
        System.out.printf("당신의 주민번호를 입력하세요.111111-1111111  >>>>");
        Scanner scanner=new Scanner(System.in);
        String reg=scanner.nextLine();
        char gender=reg.charAt(7);

        switch (gender){
            case '1': case '3':
                switch (gender){
                    case '1':
                        System.out.println("당신은 2000년 이전에 출생한 남자 입니다.");
                        break;
                    case '3':
                        System.out.println("당신은 2000년 이후에 출생한 남자 입니다.");
                        break;
                }
                break;
            case '2': case '4':
                switch (gender){
                    case '2':
                        System.out.println("당신은 2000년 이전에 태어난 여자 입니다.");
                        break;
                    case '4':
                        System.out.println("당신은 2000년 이후에 태어난 여자 입니다.");
                        break;
                }
                break;
            default:
                System.out.println("유효하지 않은 주민번호 입니다 .");
        }
    }
}
