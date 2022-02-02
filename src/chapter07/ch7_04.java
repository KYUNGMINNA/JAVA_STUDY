package chapter07;

public class ch7_04 {
    public static void main(String[] args) {



    }

}
class TV4{
    boolean power;
    int channel;

    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}
}
class VCR4{
    boolean power;
    int counter=0;
    void power(){power=!power;}
    void play(){}
    void stop(){}
    void rew(){}
    void ff(){}


}
class TVCR4 extends TV4{
    VCR4 vcr=new VCR4();

    void play(){
        vcr.play();
    }
    void stop(){
        vcr.stop();
    }
    void rew(){
        vcr.rew();
    }
    void ff(){
        vcr.ff();
    }
}
