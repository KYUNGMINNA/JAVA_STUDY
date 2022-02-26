package java2.chapter07;

public class ch7_01 {
    public static void main(String[] args) {

        CaptionTV1 captiontv=new CaptionTV1();
        captiontv.channel=10;
        captiontv.channelUp();
        System.out.println(captiontv.channel);

        captiontv.displayCaption("Hello,World");
        captiontv.caption=true;
        captiontv.displayCaption("hello,world");


    }
}
class TV1{
    boolean power;
    int channel;

    void power(){power=!power;}
    void channelUp(){++channel;}
    void channelDown(){--channel;}


}
class CaptionTV1 extends TV1{
    boolean caption;
    void displayCaption(String text){
        if(caption){
            System.out.println(text);
        }
    }
}