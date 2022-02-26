package java2.chapter04;

import java.util.*;
public class ch4_05 {
    public static void main(String[] args) {

        int score=0;
        char grade= ' ',opt='0';

        System.out.printf("점수를 입력하세요 >>");
        Scanner scanner=new Scanner(System.in);
        score=scanner.nextInt();

        System.out.printf("당신의 점수는 %d입니다",score);

        if(score>=90){
            grade='A';
            if (score >=98){
                opt='+';
            }else if(score<94) {
                opt = '-';
            }
        }else if(score>=80){
            grade='B';
            if (score >=88){
                opt='+';
            }else if(score<84){
                opt='-';
            }
        }else {
            grade='C';
        }
        System.out.printf("%c , %c ",grade,opt);
    }

}
