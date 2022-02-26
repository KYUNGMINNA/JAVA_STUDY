package java_example.chapter10;

import java.util.*;
import java.text.*;

public class ch10_15 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Scanner s = new Scanner(System.in);

        Date inDate = null;

        System.out.println("날짜를 " + pattern + "의 형태로 입력해 주세요 ");

        while (s.hasNextLine()) {
            try {
                inDate = df.parse(s.nextLine());

                break;
            } catch (Exception e) {
                System.out.println("날짜를 " + pattern + "의 형태로 입력해 주세요 ");
            }


        }

        Calendar cal=Calendar.getInstance();
        cal.setTime(inDate);
        Calendar today=Calendar.getInstance();
        long day=(cal.getTimeInMillis()- today.getTimeInMillis())/(60*60*1000);
        System.out.println("입력하신 날짜는 현재와"+day+"시간이 차이가 있습니다.");
    }

}