package chapter8;

public class ch8_09 {
    public static void main(String[] args) {
        try {
//            Exception e =new Exception("고의 오류 발생");
//            throw e;
            throw new Exception("고의 오류 발생!");
        }catch (Exception e){
            System.out.println("에러 메시지 : "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료 되었음");
    }
}
