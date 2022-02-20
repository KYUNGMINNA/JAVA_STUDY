package java.chapter04;

public class ch4_31 {

    public static void main(String[] args) {
        for (int i=0;i<=10;i++){
            if(i%3==0){
                continue;
            }
            System.out.println(i);
        }
    }
}
