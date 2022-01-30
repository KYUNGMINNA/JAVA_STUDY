package chapter7;

public class ch7_24 {
    public static void main(String[] args) {

        Fighter24 f=new Fighter24();

        if (f instanceof Unit24){
            System.out.println("f는 Unit클래스의 자손 입니다.");
        }
        if (f instanceof Fightable24){
            System.out.println("f는 Fightable24인터페이스를 구현.");
        }
        if (f instanceof Movable24){
            System.out.println("f는 Movable24인터페이스 구현.");
        }
        if (f instanceof Attackable24){
            System.out.println("f는 Attackable24인터페이스 구현");
        }
         if (f instanceof Object){
                    System.out.println("f는 Obejct클래스의 자손 입니다.");
                }

    }
}
class Fighter24 extends Unit24 implements Fightable24{
    public void move(int x,int y ){}
    public void attack(Unit24 u){}
}
class Unit24{
    int currentHp,x,y;
}
interface Fightable24 extends Movable24,Attackable24{

}
interface Movable24{public abstract void move(int x,int y);}
interface Attackable24{void attack(Unit24 u);}