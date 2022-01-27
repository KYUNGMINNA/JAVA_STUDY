package chapter6;

class Tv4{
    String color;
    boolean power;
    int channel;

    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}

}
public class ch6_04 {
    public static void main(String[] args) {
        Tv4[] tv4arr=new Tv4[3];

        for(int i=0;i<tv4arr.length;i++){
            tv4arr[i]=new Tv4();
            tv4arr[i].channel=i+10;
        }

        for (int i=0;i< tv4arr.length;i++){
            System.out.printf("tvarr[%d].channel=%d%n",i,tv4arr[i].channel);
        }

        Tv4[] tv4arr2={new Tv4(),new Tv4(),new Tv4()};
        for (int i=0;i< tv4arr2.length;i++){
            tv4arr2[i].channel=i+100;
        }
        for (int i=0;i< tv4arr2.length;i++){
            System.out.printf("tvarr4[%d].channel=%d%n",i,tv4arr2[i].channel);
        }



    }
}
