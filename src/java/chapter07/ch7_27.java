package java.chapter07;

class A27 {
    public void methodA(B27 b) {
        b.methodB();
    }
}

class B27 {
    public void methodB() {
        System.out.println("methodB()");
    }
}

public class ch7_27 {
    public static void main(String args[]) {
        A27 a = new A27();
        a.methodA(new B27());
    }
}