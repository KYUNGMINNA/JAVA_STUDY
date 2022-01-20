package chapter9;

public class ch9_01 {
    public static void main(String[] args) {
        Value v1=new Value(10);
        Value v2=new Value(10);

        //equals의 기본은 주소비교
        if (v1.equals(v2)){
            System.out.println("same");
        }else {
            System.out.println("not same");
        }

        v2=v1;
        if (v1.equals(v2)){
            System.out.println("same");
        }else {
            System.out.println("not same");
        }

    }
}
class Value{
    int value;

    Value(int value){
        this.value=value;
    }
}
