package chapter14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class ch14_15 {
    public static void main(String[] args) {
        Student15[] stuArr = {
                new Student15("나자바", true,  1, 1, 300),
                new Student15("김지미", false, 1, 1, 250),
                new Student15("김자바", true,  1, 1, 200),
                new Student15("이지미", false, 1, 2, 150),
                new Student15("남자바", true,  1, 2, 100),
                new Student15("안지미", false, 1, 2,  50),
                new Student15("황지미", false, 1, 3, 100),
                new Student15("강지미", false, 1, 3, 150),
                new Student15("이자바", true,  1, 3, 200),

                new Student15("나자바", true,  2, 1, 300),
                new Student15("김지미", false, 2, 1, 250),
                new Student15("김자바", true,  2, 1, 200),
                new Student15("이지미", false, 2, 2, 150),
                new Student15("남자바", true,  2, 2, 100),
                new Student15("안지미", false, 2, 2,  50),
                new Student15("황지미", false, 2, 3, 100),
                new Student15("강지미", false, 2, 3, 150),
                new Student15("이자바", true,  2, 3, 200)
        };
        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student15>> stuBySex =  Stream.of(stuArr)
                .collect(partitioningBy(Student15::isMale));

        List<Student15> maleStudent   = stuBySex.get(true);
        List<Student15> femaleStudent = stuBySex.get(false);

        for(Student15 s : maleStudent)   System.out.println(s);
        for(Student15 s : femaleStudent) System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student15::isMale, counting()));

        System.out.println("남학생 수 :"+ stuNumBySex.get(true));
        System.out.println("여학생 수 :"+ stuNumBySex.get(false));


        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student15>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(Student15::isMale,
                        maxBy(comparingInt(Student15::getScore))
                ));
        System.out.println("남학생 1등 :"+ topScoreBySex.get(true));
        System.out.println("여학생 1등 :"+ topScoreBySex.get(false));

        Map<Boolean, Student15> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(Student15::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(Student15::getScore)), Optional::get
                        )
                ));
        System.out.println("남학생 1등 :"+ topScoreBySex2.get(true));
        System.out.println("여학생 1등 :"+ topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<Student15>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(Student15::isMale,
                        partitioningBy(s -> s.getScore() <= 100))
                );
        List<Student15> failedMaleStu   = failedStuBySex.get(true).get(true);
        List<Student15> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(Student15 s : failedMaleStu)   System.out.println(s);
        for(Student15 s : failedFemaleStu) System.out.println(s);
    }
}
class Student15 {
    String name;
    boolean isMale;

    int hak;
    int ban;
    int score;

    Student15(String name, boolean isMale, int hak, int ban, int score) {
        this.isMale	= isMale;
        this.name	= name;
        this.hak	= hak;
        this.ban	= ban;
        this.score  = score;
    }
    String	getName()  { return name;}
    boolean isMale()    { return isMale;}
    int		getHak()   { return hak;}
    int		getBan()   { return ban;}
    int		getScore() { return score;}

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }

    enum Level { HIGH, MID, LOW }
}