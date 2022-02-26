package java2.chapter09;

public class ch9_02 {
    public static void main(String[] args) {

        Person p1=new Person(12345678L);
        Person p2=new Person(12345678L);

        if (p2==p1){
            System.out.println("same");
        }else {
            System.out.println("not same");
        }

        if (p2.equals(p1)){
            System.out.println("same");
        }else {
            System.out.println("not same");
        }
    }

}
class Person{
    long id;

    //값 비교를위한 오버라이딩
    public boolean equals(Object obj){
        if (!(obj instanceof Person)) return false;

        return this.id==((Person)obj).id;
    }
    Person(long id){
        this.id=id;
    }
}
