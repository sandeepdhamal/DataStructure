package interview;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxNumber {

    public static void main(String[] args) {
        int arr[] = {1, 2, 23, 3, 4, 5};
        maxNumberUsingJava7(arr);
        maxNumberUsingJava8MaxMethod(arr);
        maxNumberUsingJava8Sorted(arr);
    }

    private static void maxNumberUsingJava8Sorted(int[] arr) {
        Optional<Integer> first = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).findFirst();
        first.ifPresent(integer -> System.out.println("Max using java8 findFirst:-" + integer));
    }

    private static void maxNumberUsingJava8MaxMethod(int[] arr) {
        OptionalInt max = Arrays.stream(arr).distinct().max();
        max.ifPresent(integer -> System.out.println("Max using java8 :-" + integer));
    }

    private static void maxNumberUsingJava7(int[] arr) {
        //Logic 1 using java 7
        int maxNo = 0;
        for (int num : arr) {
            if (num > maxNo) {
                maxNo = num;
            }
        }
        System.out.println("Max using java7 :- " + maxNo);
    }
}
