package java_example.chapter09;

public class ch9_19 {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer("01");
        StringBuffer sb2=sb.append(23);

        sb.append('4').append(56);

        StringBuffer sb3=sb.append(78);
        sb3.append(9.0);
        System.out.println("Sb : "+sb);
        System.out.println("Sb2 : "+sb2);
        System.out.println("Sb3 : "+sb3);


        System.out.println("sb = "+sb.deleteCharAt(10));
        System.out.println("sb = "+sb.delete(3,6));
        System.out.println("sb= "+sb.insert(3,"abc"));
        System.out.println("sb= "+sb.replace(6,sb.length(),"END"));

        System.out.println("capacity : "+sb.capacity());
        System.out.println("length : "+sb.length());





        System.out.println("hasdoCode( ) ");
        System.out.println(sb.hashCode());
        System.out.println(sb2.hashCode());
        System.out.println(sb3.hashCode());



    }
}
