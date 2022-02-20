package java.chapter05;

public class ch5_17 {
    public static void main(String[] args) {
        if(args.length!=3){
            System.out.println("usage java ");
            System.exit(0);
        }

        int num1=Integer.parseInt(args[0]);
        char op=args[0].charAt(0);
        int num2=Integer.parseInt(args[2]);
        int result=0;


        switch (op){
            case '+':
                result=num1+num2;
                break;

            case '-':
                result=num1-num2;
                break;
            case 'x':
                result=num1*num2;
                break;
            case '/':
                result=num1/num2;
                break;
            default:
                System.out.println("지원하지 안는 연산");
        }
        System.out.println("결과 ; "+result);
    }
}
