package java_example.chapter04;

import java.util.Scanner;

public class ch4_17 {
    public static void main(String[] args) {
        int num=0;

        System.out.printf("*를 출력할 라인의 수를 입력하세요");
        Scanner scanner=new Scanner(System.in);
        num=scanner.nextInt();
        //String input=scanner.nextLine();
        //num=Integer.parseInt(input);

        for (int i=0;i<num;i++){
            for (int j=0;j<=i;j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
