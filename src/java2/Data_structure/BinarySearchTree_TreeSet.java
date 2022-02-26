package java2.Data_structure;

import java.util.TreeSet;

public class BinarySearchTree_TreeSet {
    public static void main(String[] args) {
        TreeSet treeSet=new TreeSet();

        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(4);
        treeSet.add(8);

        System.out.println("5->2->1->4->8");
        System.out.println(treeSet);


        //범위 검색
        System.out.println("범위 검색 subset(3,9) (from<=treeset<to)  :"+treeSet.subSet(3,9));

        //제일 큰 값
        System.out.println("제일 큰 값 pollLast :"+treeSet.pollLast());

        //제일 작은 값
        System.out.println("제일 작은 값 PollFirst :"+treeSet.pollFirst());


        //보다 큰 값
        System.out.println("보다 큰 값 tailset :"+treeSet.tailSet(3));

        //보다 작은 값
        System.out.println("보다 작은 값 headset : "+treeSet.headSet(4));
    }
}