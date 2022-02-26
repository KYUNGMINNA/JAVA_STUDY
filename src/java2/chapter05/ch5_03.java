package java2.chapter05;

public class ch5_03 {
    public static void main(String[] args) {
        int[] arr=new int[5];
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        System.out.println("before change");
        System.out.println("arr.length : "+arr.length);
        for (int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]");
        }

        int[] tmp=new int[arr.length];

        for (int i=0;i<arr.length;i++) tmp[i]=arr[i];

        arr=tmp;

        System.out.println("after change");
        System.out.println("arr.length :"+arr.length);

        for (int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"] : "+arr[i]);
        }



    }

}
