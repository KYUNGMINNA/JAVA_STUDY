package java_example.chapter07;

public class ch7_26 {
    public static void main(String[] args) {
    Tank26 t=new Tank26();
    DropShip26 d=new DropShip26();
    Marine26 m=new Marine26();
    SCV26 s=new SCV26();
    s.repair(t);
    s.repair(d);
    //s.repair(m);

    }
}
interface Repariable{}

class Unit26{
    int hitPoint;
    final int MAX_HP;
    Unit26 (int hp){
        MAX_HP=hp;
    }
}

class GrounUnit26 extends Unit26{
    GrounUnit26(int hp){
        super(hp);
    }
}
class AirUnit26 extends Unit26{
    AirUnit26(int hp){
        super(hp);
    }
}
class Tank26 extends GrounUnit26 implements Repariable{
    Tank26(){
        super(150);
        hitPoint=MAX_HP;
    }
    public String toString(){
        return "Tank";
    }
}
class DropShip26 extends AirUnit26 implements Repariable{
        DropShip26(){
            super(125);
            hitPoint=MAX_HP;
        }
        public String toString(){
            return "DropShip";
        }
}
class Marine26 extends GrounUnit26{
    Marine26(){
        super(40);
        hitPoint=MAX_HP;
    }
}
class SCV26 extends GrounUnit26 implements Repariable{
    SCV26(){
        super(60);
        hitPoint=MAX_HP;
    }
    void repair(Repariable r){
        if(r instanceof Unit26){
            Unit26 u=(Unit26) r;
            while(u.hitPoint!=u.MAX_HP){
                u.hitPoint++;
            }
            System.out.println(u.toString()+"의 수리가 끝났습니다.");
        }
    }
}