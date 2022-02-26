package java2.chapter15;

public class ch15_39 implements java.io.Serializable{
    String name;
    String password;
    int age;

    public ch15_39(){
        this("Unkown","1111",0);
    }
    public ch15_39(String name,String password,int age){
        this.name=name;
        this.password=password;
        this.age=age;
    }
    public String toString(){
        return "("+name+","+password+","+age+")";
    }
}
