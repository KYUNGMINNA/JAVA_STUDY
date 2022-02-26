package java2.chapter09;

public class ch9_16 {
    public static void main(String[] args) {
        int ival=100;
        String strval=String.valueOf(ival);


        double dval=200.0;
        String strval2=dval+"";

        double sum=Integer.parseInt("+"+strval)+Double.parseDouble(strval2);

        double sum2=Integer.valueOf(strval)+Double.valueOf(strval2);

        System.out.println(String.join("",strval,"+",strval2,"=")+sum);
        System.out.println(strval+"+"+strval2+"="+sum2);
    }
}

