package java_study;

import java.lang.reflect.Array;
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




    }
}
