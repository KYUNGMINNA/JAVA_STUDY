package chapter07;

public class ch7_07 {

    public static void main(String[] args) {
        Point3D7 p=new Point3D7(1,2,3);
        System.out.println(p.getLocation());
    }
}
class Point7{
    int x,y;

    Point7(int x,int y){

        this.x=x;
        this.y=y;

    }
    String getLocation(){
        return "x:"+x+",y:"+y;
    }
}
class Point3D7 extends Point7{
    int z;

    Point3D7(int x, int y , int z){
        super(x,y);
        this.z=z;
    }
    String getLocation(){
        return "x: "+x+",y:"+y+",z:"+z;
    }
}