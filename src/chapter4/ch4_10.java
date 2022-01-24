package chapter4;

import  java.util.*;
public class ch4_10 {
    public static void main(String[] args) {

        int score=0;
        char grade=' ';

        System.out.printf("당신의 점수를 입력하세요 : >>> ");
        Scanner scanner=new Scanner(System.in);
        String tmp=scanner.nextLine();
        score=Integer.parseInt(tmp);

        switch (score/10){
            case 10: case 9:
                grade='A';
                break;
            case 8:
                grade='B';
                break;
            case 7:
               grade='C';
               break;
            case 6:
                grade='D';
                break;
            case 5:
                grade='E';
                break;
            default:
                grade='F';


            }
        System.out.printf("점수 %d , 성적 %c",score,grade);



    }

}
