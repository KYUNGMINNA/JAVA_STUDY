package chapter6;

public class ch6_07 {
    public static void main(String[] args) {
        firstmethod();
    }
    static void firstmethod(){
        secondmethod();
    }
    static void secondmethod(){
        System.out.println("secondmethod()");
    }
}
