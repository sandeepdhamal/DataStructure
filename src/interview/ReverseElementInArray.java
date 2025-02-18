package interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseElementInArray {

    public static void main(String[] args) {
        reverseArrayUsingWhileLoop();
        reverseArrayUsingLoop();
        reverseArrayUsingIntStream();
        reverseArrayUsingReverse();

    }

    private static void reverseArrayUsingReverse() {
        Integer[] arr1 = {1, 2, 23, 3, 4, 5}; // Use Integer[] for Collections.reverse()
        List<Integer> list = Arrays.asList(arr1);
        Collections.reverse(list);
        arr1 = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(arr1));
    }

    private static void reverseArrayUsingIntStream() {
        int arr[] = {1, 2, 23, 3, 4, 5};
        int[] reversedArr = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();
        System.out.println(Arrays.toString(reversedArr));
    }

    private static void reverseArrayUsingLoop() {
        int arr[] = {1, 2, 23, 3, 4, 5};
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void reverseArrayUsingWhileLoop() {
        int arr[] = {1, 2, 23, 3, 4, 5};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
