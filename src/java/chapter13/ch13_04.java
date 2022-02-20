package java.chapter13;

public class ch13_04 {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();

        for (int i=0;i<300;i++)
        {
            System.out.printf("%s",new String("-"));
        }
        System.out.print("소요 시간 1"+(System.currentTimeMillis()-startTime));


        for (int i=0;i<300;i++)
        {
            System.out.printf("%s",new String("|"));
        }
        System.out.print("소요 시간 2"+(System.currentTimeMillis()-startTime));





    }
}
