package chapter10;

import java.text.*;

public class ch10_16 {
    public static void main(String[] args) {
        double[] limits={60,70,80,90};
        String[] grades={"D","C","B","A"};
        int[] score={100,95,88,70,52,60,70};
        ChoiceFormat form=new ChoiceFormat(limits,grades);

        for (int i=0;i< score.length;i++){
            System.out.println(score[i]+":"+form.format(score[i]));
        }
    }
}
