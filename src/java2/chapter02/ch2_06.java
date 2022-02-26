package java2.chapter02;

import java.util.*;
public class ch2_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("두자리 정수를 입력해 주세요:");
        String input=scanner.nextLine();
        int num=Integer.parseInt(input);
        System.out.println("입력 내용(문자열):"+input);
        System.out.printf("입력한 내용을 정수로 변환 -- number=%d",num);


    }

}
