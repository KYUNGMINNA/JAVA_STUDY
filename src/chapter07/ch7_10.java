package chapter07;

import java.util.Date;
import java.text.SimpleDateFormat;
public class ch7_10 {
    public static void main(String[] args) {
        Date today=new Date();

        SimpleDateFormat date=new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time=new SimpleDateFormat("hh:mm:ss a");

        System.out.println(date.format(today));
        System.out.println(time.format(today));

    }

}
