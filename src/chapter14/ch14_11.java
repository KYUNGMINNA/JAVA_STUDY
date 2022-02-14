package chapter14;

import java.util.*;
import java.util.stream.*;

public class ch14_11 {
    public static void main(String[] args) {

        Student11[] stuArr = {
                new Student11("이자바", 3, 300),
                new Student11("김자바", 1, 200),
                new Student11("안자바", 2, 100),
                new Student11("박자바", 2, 150),
                new Student11("소자바", 1, 200),
                new Student11("나자바", 3, 290),
                new Student11("감자바", 3, 180)
        };

        Stream<Student11> stuStream = Stream.of(stuArr);

        stuStream.sorted(Comparator.comparing(Student11::getBan)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr); // 스트림을 다시 생성한다.
        IntStream stuScoreStream= stuStream.mapToInt(Student11::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count="+stat.getCount());
        System.out.println("sum="+stat.getSum());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min="+stat.getMin());
        System.out.println("max="+stat.getMax());
    }
}

class Student11 implements Comparable<Student11> {
    String name;
    int ban;
    int totalScore;
    Student11(String name, int ban, int totalScore) {
        this.name = name;
        this.ban  = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName()	{ return name;}
    int getBan()		{ return ban;}
    int getTotalScore() { return totalScore;}

    public int compareTo(Student11 s) {
        return s.totalScore - this.totalScore;
    }
}
