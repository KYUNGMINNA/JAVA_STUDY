package java2.chapter14;

public class ch14_02 {

    public static void main(String[] args) {


        MyFunction2 f1 = () -> {};
        Object obj = (MyFunction2) (() -> {});
        String str = ((Object) (MyFunction2) (() -> {})).toString();

        System.out.println(f1);
        System.out.println(obj);
        System.out.println(str);

        System.out.println((MyFunction2)()->{});
        System.out.println((Object) (MyFunction2)()->{});

    }
}
@FunctionalInterface
interface MyFunction2{
    public  abstract void myMethod();
}