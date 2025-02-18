package interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CountEvenOddJava7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        countEvenOdd(arr);
    }

    public static void countEvenOdd(int[] arr) {
        int evenCount = 0, oddCount = 0;

        for (int num : arr) {  // Iterating through the array
            if (num % 2 == 0) {
                evenCount++;  // Increment even count
            } else {
                oddCount++;   // Increment odd count
            }
        }

        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);

        countEvenOddJava8(arr);

        countEvenOddUsingMapPartitioningBy(arr);
    }

    private static void countEvenOddUsingMapPartitioningBy(int[] arr) {
        Map<Boolean, Long> evenOddCount = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.counting()));

        System.out.println("Even Count: " + evenOddCount.get(true));
        System.out.println("Odd Count: " + evenOddCount.get(false));
        System.out.println("Odd Count: " + evenOddCount);

    }

    private static void countEvenOddJava8(int[] arr) {
        // Counting even numbers
        long evenCount = Arrays.stream(arr).filter(num -> num % 2 == 0).count();

        // Counting odd numbers
        long oddCount = Arrays.stream(arr).filter(num -> num % 2 != 0).count();

        System.out.println("Even Count: " + evenCount);
        System.out.println("Odd Count: " + oddCount);
    }


}
