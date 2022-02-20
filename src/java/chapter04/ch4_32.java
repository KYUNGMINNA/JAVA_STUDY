package java.chapter04;

import java.util.*;
public class ch4_32 {
    public static void main(String[] args) {
        int menu=0,num=0;

        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");

            String tmp=scanner.nextLine();
            menu=Integer.parseInt(tmp);

            if(menu==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if (!(1<=menu && menu<=3)){
                System.out.println("메뉴를 잘못 선택하셨습니다 (쫑료는 0) ");
                continue;
            }

            System.out.println("선택하신 메뉴는 "+menu+"입니다.");
        }

    }
}
