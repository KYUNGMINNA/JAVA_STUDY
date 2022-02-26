package java2.chapter11;

import java.util.*;

public class ch11_30 {

    public static void main(String[] args) {
        HashMap hashMap=new HashMap();

        hashMap.put("myId","1234");
        hashMap.put("asdf","1111");
        hashMap.put("asdf","1234");

        Scanner scanner=new Scanner(System.in);

        while(true) {

            System.out.println("id 와 password를 입력해 주세요 ");
            System.out.println("id : ");
            String id = scanner.nextLine().trim();

            System.out.println("password :");
            String password = scanner.nextLine().trim();
            System.out.println();

            if (!hashMap.containsKey(id)) {
                System.out.println("입력하신 id는 존재하지 않습니다 다시입력해 주세요");
               continue;

            }
            if (!(hashMap.get(id)).equals(password)) {
                System.out.println("입력하신 id와 비밀번호가 일치하지 않습니다 다시 입력해 주세요");

            }else{
                System.out.println("id와 비밀번호가 일치합니다.");
                break;
            }
        }



    }
}
