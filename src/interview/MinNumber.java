package interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MinNumber {

    public static void main(String[] args) {
        int arr[] = {-7, 1, 2, 23, 3, 4, 5};
        minNumberUsingJava7(arr);
        minNumberUsingJava8minMethod(arr);
        minNumberUsingJava8Sorted(arr);
    }

    private static void minNumberUsingJava8Sorted(int[] arr) {
        Optional<Integer> first = Arrays.stream(arr).distinct().boxed().sorted().findFirst();
        first.ifPresent(integer -> System.out.println("min using java8 findFirst:-" + integer));
    }

    private static void minNumberUsingJava8minMethod(int[] arr) {
        OptionalInt min = Arrays.stream(arr).distinct().min();
        min.ifPresent(integer -> System.out.println("min using java8 :-" + integer));
    }

    private static void minNumberUsingJava7(int[] arr) {
        //Logic 1 using java 7
        int minNo = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < minNo) {
                minNo = num;
            }
        }
        System.out.println("min using java7 :- " + minNo);
    }
}
