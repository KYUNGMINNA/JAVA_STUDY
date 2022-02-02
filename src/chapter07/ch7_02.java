package chapter07;

public class ch7_02 {
    public static void main(String[] args) {

        Point2[] p={
                new Point2(100,100),
                new Point2(140,50),
                new Point2(200,100)
        };


        Triangle2 t=new Triangle2(p);
        Circle2 c=new Circle2(new Point2(150,150),50);

        t.draw();
        c.draw();

    }

}
class Shape2{
    String color="black";
    void draw(){
        System.out.printf("[color=%s]%n",color);
    }

}
class Point2{
    int x,y;

    Point2(int x,int y){
        this.x=x;
        this.y=y;
    }
    Point2(){
        this(0,0);
    }
    String getXY(){
        return "("+x+","+y+")";
    }
}
class Circle2 extends Shape2{
    Point2 center;
    int r;

    Circle2(){
        this(new Point2(10,0),100);
    }
    Circle2(Point2 center,int r){
        this.center=center;
        this.r=r;


    }


    void draw(){
        System.out.printf("[center=(%d,%d), r=%d, color=%s]%n",center.x,center.y,r,color);
    }
}
class Triangle2 extends  Shape2{
    Point2[] p =new Point2[3];
    Triangle2(Point2[] p){
        this.p=p;
    }
    void draw(){
        System.out.printf("[p1=%s , p2=%s , p3=%s ,color=%s]%n",p[0].getXY(),p[1].getXY(),p[2].getXY(),color);
    }
}