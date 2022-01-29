package chapter7;

public class ch7_13 {
    public static void main(String[] args){

        Time13 t=new Time13(12,35,30);
        System.out.println(t);  // t.toString()
        t.setHour(t.getHour()+1);
        System.out.println(t);

    }
}
class Time13{
    private int hour,minute,second;

    Time13(int hour,int minute,int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);

    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if(hour<0 || hour>23) return;
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if(minute<0 || minute>59) return;
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if(second<0 || second>59) return;

        this.second = second;
    }
    public String toString(){
        return hour+":"+minute+":"+second;
    }
}
