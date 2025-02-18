package interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxNumberMinNumber {

    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {

                min = arr[i];
            }

        }
        System.out.println(max);
        System.out.println(min);
        Optional<Integer> firstMax = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).reduce((a, b) -> a);
        Optional<Integer> firstMin = Arrays.stream(arr).distinct().boxed().sorted().findFirst();
        firstMax.ifPresent(integer -> System.out.println("firstMax " + integer));
        firstMin.ifPresent(integer -> System.out.println("firstMin " + integer));

        Optional<Integer> firstMaxFirst = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).findFirst();
        firstMaxFirst.ifPresent(integer -> System.out.println("firstMaxFirst " + integer));
        Integer maxNN = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).reduce((a, b) -> b).get();
        System.out.println("maxNN "+maxNN);
        OptionalInt max1 = Arrays.stream(arr).distinct().max();
        System.out.println("max1 "+max1);
        OptionalInt min1 = Arrays.stream(arr).distinct().min();
        System.out.println("min1 "+min1);



        Optional<Integer> secondMax = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).skip(1).findFirst();
        Optional<Integer> secondMin = Arrays.stream(arr).distinct().boxed().sorted().skip(1).findFirst();

        secondMax.ifPresent(integer -> System.out.println("secondMax " + integer));
        secondMin.ifPresent(integer -> System.out.println("secondMin " + integer));

        int sum = Arrays.stream(arr)
                .distinct()
                .boxed()
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }


}
