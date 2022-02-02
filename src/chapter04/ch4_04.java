package chapter04;

import java.util.*;
public class ch4_04 {
    public static void main(String[] args) {

        int score=0;
        char grade=' ';

        System.out.printf("점수를 입력하세요 >> ");
        Scanner scanner=new Scanner(System.in);
        score=scanner.nextInt();
        if (score>=90){
            grade='A';
        }else if (score>=80){
            grade='B';
        }else if (score>=70){
            grade='C';
        }else if (score>=60){
            grade='D';
        }else {
            grade='D';
        }
        System.out.printf("당신의 점수는 %d 이며 성적은 %c입니다.",score,grade);
    }

}
