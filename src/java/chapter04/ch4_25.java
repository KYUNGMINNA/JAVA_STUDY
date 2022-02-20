package java.chapter04;

import java.util.*;
public class ch4_25 {
    public static void main(String[] args) {
        int num=0,sum=0;

        System.out.print("숫자를 입력하세요 >>>");
        Scanner scanner=new Scanner(System.in);
        num=scanner.nextInt();

        while(num!=0){
            sum+=num%10;
            System.out.printf("sum=%3d num=%d%n",sum,num);

            num/=10;
        }
        System.out.println("각 자리수의 합 :"+sum);


    }
}
