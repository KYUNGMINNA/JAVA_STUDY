package chapter06;

public class ch6_29 {
    public static void main(String[] args) {

        Product p1=new Product();
        Product p2=new Product();
        Product p3=new Product();

        System.out.println("p1의 제품 번호는 : "+p1.serialno);
        System.out.println("p3의 제품 번호는 : "+p2.serialno);
        System.out.println("p2의 제품 번호는 : "+p3.serialno);

    }
}
class  Product{
    static  int count=0;
    int serialno;

    {
        ++count;
        serialno=count;
    }

    public Product(){}
}