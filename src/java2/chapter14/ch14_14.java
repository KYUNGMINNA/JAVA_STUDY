package java2.chapter14;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class ch14_14 {
    public static void main(String[] args) {
        Student14[] stuArr = {
                new Student14("이자바", 3, 300),
                new Student14("김자바", 1, 200),
                new Student14("안자바", 2, 100),
                new Student14("박자바", 2, 150),
                new Student14("소자바", 1, 200),
                new Student14("나자바", 3, 290),
                new Student14("감자바", 3, 180)
        };

        List<String> names = Stream.of(stuArr)
                                .map(Student14::getName)
                                .collect(Collectors.toList());
        System.out.println(names);

        Student14[] stuArr2=Stream.of(stuArr).toArray(Student14[]::new);

        for(Student14 s : stuArr2)
            System.out.println(s);

        Map<String,Student14> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s->s.getName(), p->p));
        for(String name : stuMap.keySet())
            System.out.println(name +"-"+stuMap.get(name));

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                .collect(summingInt(Student14::getTotalScore));
        System.out.println("count="+count);
        System.out.println("totalScore="+totalScore);

        totalScore = Stream.of(stuArr)
                .collect(reducing(0, Student14::getTotalScore, Integer::sum));
        System.out.println("totalScore="+totalScore);

        Optional<Student14> topStudent = Stream.of(stuArr)
                .collect(maxBy(Comparator.comparingInt(Student14::getTotalScore)));
        System.out.println("topStudent="+topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuArr)
                .collect(summarizingInt(Student14::getTotalScore));
        System.out.println(stat);

        String stuNames = Stream.of(stuArr)
                .map(Student14::getName)
                .collect(joining(",", "{", "}"));
        System.out.println(stuNames);




    }
}
class Student14 implements Comparable<Student14> {
    String name;
    int ban;
    int totalScore;

    Student14(String name, int ban, int totalScore) {
        this.name =name;
        this.ban =ban;
        this.totalScore =totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName() { return name;}
    int getBan() { return ban;}
    int getTotalScore() { return totalScore;}

    public int compareTo(Student14 s) {
        return s.totalScore - this.totalScore;
    }
}

