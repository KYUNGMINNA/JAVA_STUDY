package java_study;

public class chapter4_loop {
    public static void main(String[] args) {


        //if문
        if(조건식){

        }
        else if(조건식){

        }
        else  //else 생략 가능


        if(조건식) System.out.println("블럭 내 한문장일때 사용방법");



        switch (조건식){  //조건식은 정수 or 문자(유니코드로 저장됌) or 문자열
            case 값:  // 값은 정수 or 문자 or 문자열

                break;
            case 값: case 값: case 값 :
                break;
            case 값:    //아무것도 없으면 break 안써도 됌 그러나 내용 있으면 무조건 break  // 마지막 문장일 경우 break 생략 가능

            default: //  원하는 값 없으면  default 실행

        }

        //삼항 연산자
        int a=3,b=4;
        int c=1,d=2;
        System.out.println("삼항 연산자 연산자 참이면 c ,거짓이면 d: (a>b)?c:d "+((a>b)?c:d));


        //특수 for문
        for (int i=1,j=2;i<5;i++,--j){

        }

        //무한 반복문
        // for (;;);


        //for (타입 변수명 : 배열 또는 컬렉션)
        int[] arr={10,20,30,40,50};
        for (int tmp:arr){
            System.out.println(tmp);
        }


//        while(true){  //조건식이 참일 동안 반복될 문장을 적는다
//            System.out.println("test");
//        }


        //do while은 최소한 한번의 문장은 수행 한다 .
//        do{
//              //조건식 연산결과 참일때 수행될 문장들을 적는다
//            System.out.println("test123");
//        }while (true);

        //continue 반복문 내에서만 사용 가능
//        for(int i=1;i<=10;i++){
//            if (i%3==0){
//                continue;
//            }
//            System.out.println(i);
//
//        }


        //이름 붙은 반복문

        Loop1:for(int i=2;i<10;i++){
            for(int j=1;j<10;j++){
                if(j==5)
                    break Loop1;
                    //break;
                    //continue Loop1;
                    //continue;
                System.out.println(i+"*"+j+"="+i*j);

            }
            System.out.println();
        }
    }
}
