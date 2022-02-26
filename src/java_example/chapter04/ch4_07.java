package java_example.chapter04;

import  java.util.*;
public class ch4_07 {

    public static void main(String[] args) {

        System.out.printf("가위(1) 바위(2) 보(3) 중 하나를 입력하세요 >>>");
        Scanner scanner=new Scanner(System.in);
        int user=scanner.nextInt();
        int com=(int)(Math.random()*3)+1;


        switch (user-com){
            case 2: case -1:
                System.out.printf("당신이 졌습니다.");
                break;
            case 1: case -2:
                System.out.printf("당신이 이겼습니다.");
                break;
            case 0:
                System.out.printf("비겼습니다.");
        }
    }
}
