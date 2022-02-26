package java2.chapter03_연습문제;

public class ch3_10 {
    public static void main(String[] args) {
        char ch = 'A';
        //char lowerCase = ( ch<97 ) ? ((char)(ch+32)) : ch;
        char lowerCase = ( 'A'<=ch && ch<='Z' ) ? ((char)(ch+32)) : ch;

        System.out.println("ch:"+ch);
        System.out.println("ch to lowerCase:"+lowerCase);

    }
}
