package interview;

import java.util.Arrays;

public class SumOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        findSumJava7(arr);
        findSumJava8(arr);
        findSumJava8Reduce(arr);

    }

    private static void findSumJava8Reduce(int[] arr) {

        int sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println("Sum using Reduce: " + sum);
    }

    private static void findSumJava8(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        System.out.println("Sum java 8: " + sum);
    }

    public static void findSumJava7(int[] arr) {
        int sum = 0;
        for (int num : arr) {  // Iterating over the array
            sum = sum + num;        // Adding each element to sum
        }
        System.out.println("Sum: " + sum);
    }
}
