package chapter06;

public class ch6_23 {
    public static void main(String[] args) {

        Data1 d1=new Data1();
        Data22 d2=new Data22(10);
    }
}
class Data1{
    int value;
}
class  Data22{
    int value;

    Data22(int x){
        value=x;
    }
}