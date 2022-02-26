package java2.chapter14;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ch14_17 {
    public static void main(String[] args) {
        String[] strArr = { "aaa","bbb","ccc" };
        Stream<String> strStream = Stream.of(strArr);

        String result = strStream.collect(new ConcatCollector());

        System.out.println(Arrays.toString(strArr));
        System.out.println("result="+result);
    }
}
class ConcatCollector implements Collector<String,StringBuilder,String>{
    @Override
    public Supplier<StringBuilder> supplier(){
        return () -> new StringBuilder();
    }
    @Override
    public BiConsumer<StringBuilder, String> accumulator() {
        return (sb, s) -> sb.append(s);
    }
    @Override
    public Function<StringBuilder, String> finisher() {
        return sb -> sb.toString();
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (sb, sb2)-> {
            sb.append(sb2);
            return sb;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
