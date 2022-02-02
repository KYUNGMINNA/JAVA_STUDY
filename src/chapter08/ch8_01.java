package chapter08;

public class ch8_01 {
    public static void main(String[] args) {
        try{System.out.println("first try call");
            try {System.out.println("second try call");}catch (Exception e){}
        }catch (Exception e){
            try {}catch (Exception e2){}
        }

        try{
        }catch (Exception e){
        }

    }
}
