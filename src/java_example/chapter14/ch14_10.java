package java_example.chapter14;

import java.util.*;
import java.util.stream.*;

public class ch14_10 {
    public static void main(String[] args){
        Student10[] stuArr = {
                new Student10("이자바", 3, 300),
                new Student10("김자바", 1, 200),
                new Student10("안자바", 2, 100),
                new Student10("박자바", 2, 150),
                new Student10("소자바", 1, 200),
                new Student10("나자바", 3, 290),
                new Student10("감자바", 3, 180)
        };

        Stream<Student10> stuStream=Stream.of(stuArr);
        stuStream.sorted(Comparator.comparing(Student10::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
        stuStream=Stream.of(stuArr);

        IntStream stuScoreStream=stuStream.mapToInt(Student10::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count="+stat.getCount());
        System.out.println("sum="+stat.getSum());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min="+stat.getMin());
        System.out.println("max="+stat.getMax());
    }
}
class Student10 implements Comparable<Student10>{
    String name;
    int ban;
    int totalScore;
    Student10(String name,int ban,int totalScore){
        this.name=name;
        this.ban=ban;
        this.totalScore=totalScore;
    }
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName()	{ return name;}
    int getBan()		{ return ban;}
    int getTotalScore() { return totalScore;}

    public int compareTo(Student10 s) {
        return s.totalScore - this.totalScore;
    }
}