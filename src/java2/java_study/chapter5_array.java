package java2.java_study;

import java.util.Arrays;

public class chapter5_array {
    public static void main(String[] args) {

        //배열의 선언
        int[] a;
        int b[];

        //배열의 생성--길이 지정해야함
        int[] a1=new int[1];
        int b1[]=new int[2];

        //길이가 0인 배열
        int[] arr=new int[0];
        int[] arr1=new int[]{};
        int[] arr2={};


        //배열의 초기화
        int[] score=new int[5];
        score[0]=1;
        score[1]=2;
        score[2]=3;
        score[3]=4;
        score[4]=5;
        // 같은 방법
        int[] score1=new int[]{1,2,3,4,5};
        int[] score2={1,2,3,4,5};

        //그러나
        int[] score3;
        score3=new int[]{1,2,3,4,5};
        //이렇게는 가능하나
        //score3={1,2,3,4,5}; 이렇게는 불가능


        //배열의 출력
        for(int i=0;i<score.length;i++){
            System.out.printf(score[i]+",");
        }
        System.out.println(Arrays.toString(score));

        //특이하게 char 타입은 println메서드에서  변수이름으로 출력
        char[] cha={'a','b','c'};
        System.out.println(cha);

        //배열의 복사
        int[] copy1=new int[3];
        int[] copy2=new int[5];

        for (int i=0;i<copy1.length;i++){
            copy2[i]=copy1[i];
        }
        copy1=copy2;


        //System.arraycopy()
//        int[] copy1=new int[3];
//        int[] copy2=new int[5];
//
//        for (int i=0;i<copy1.length;i++){
//            copy2[i]=copy1[i];
//        }
        //===
        int[] copy3=new int[10];
        System.arraycopy(copy1,0,copy3,0,copy1.length);
        //copy[0] 에서 copy[3]으로 ,copy.length개의 데이터 복사

        //String 배열
        String[] str=new String[3];
        str[0]="a";  //원래는 str[0]=new String("a"); 이나 생략 가능
        str[1]="b";
        str[2]="c";

        String[] str2=new String[]{"a","b","c"};
        String[] str3={"a","b","c"};

        //char배열 -> String클래스
        char[] chararr={'a','b','c'};

        System.out.println("char ->String");
        String strch=new String(chararr); // char배열 을 string으로


        char[] temp=strch.toCharArray();  //string을 char배열로
        System.out.println(temp);


        //2차원 배열  선언
        int[][] multimatrix=new int[3][3];

        //2차원 배열 초기화
        int[][] multimatrix2=new int[][]{{1,2,3,},{5,6,7}};
        int[][] multimatrix3={{1,2,3,},{5,6,7}};

        for(int i=0;i<multimatrix2.length;i++){
            for(int j=0;j<multimatrix2[i].length;j++){
                multimatrix2[i][j]=10;
            }
        }

        //가변 배열
        int[][] fake=new int[5][];
        fake[0]=new int[4];  //1행 - 값 4개
        fake[1]=new int[3];  //2행 값 3개
        fake[2]=new int[2]; //3행 값 2개
        fake[3]=new int[1]; //4행 값 1개



    }
}
