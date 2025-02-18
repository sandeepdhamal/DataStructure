package stream.grouping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApi {

    public static void main(String[] args) {


        String str = "Hello World";

        Map<String, Long> collect = str.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Character c1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(c1);

        List<Character> collect1 = str.chars().mapToObj(c -> (char) c).collect
                        (Collectors.groupingBy(Function.identity(),
                                LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect1);

        LinkedHashMap<Character, Long> collect2 = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        List<Character> collect3 = collect2.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect3);

    }

}
