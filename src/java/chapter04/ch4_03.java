package java.chapter04;
import java.util.*;
public class ch4_03 {
    public static void main(String[] args) {
        System.out.printf("숫자 하나 입력하세요 >>");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();

        if (input==0){
            System.out.printf("입력하신 숫자는 0%n");
        }else{
            System.out.printf("입력한 숫자는 0이 아니고 , %d입니다%n",input);
        }


    }

}
