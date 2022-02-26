package java_example.chapter04;

import java.util.*;
public class ch4_27 {
    public static void main(String[] args) {
        int num,sum=0;
        boolean flag=true;

        Scanner scanner=new Scanner(System.in);
        System.out.println("숫자를 입력하세요 ( 0 입력하면 종료 )");

        while(flag){
            System.out.print(">>");
            String tmp=scanner.nextLine();
            num=Integer.parseInt(tmp);

            if(num!=0){
                sum+=num;
            }else {
                flag=false;
            }

        }
        System.out.println("합계 : "+sum);
    }
}
