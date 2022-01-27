package chapter6;

public class ch6_8 {
    public static void main(String[] args) {
        System.out.println("main[String[] args]가 시작 되었음");
        firstmethod();
        System.out.println("main[String[] args]가 끝났음");
    }
    static void firstmethod(){
        System.out.println("firstmenthod()가 시작 되었음");

        secondmethod();
        System.out.println("firstmethod()가 끝났음");
    }
    static void secondmethod(){
        System.out.println("secondmethod()가 시작 되었음");
        System.out.println("secondmethod()가 종료 되었음");
    }
}
