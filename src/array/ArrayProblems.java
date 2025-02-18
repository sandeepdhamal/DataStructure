package array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayProblems {

    // 1. Find the maximum element in an array
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMaxJava8(int[] arr) {
        return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
    }

    // 2. Find the minimum element in an array
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMinJava8(int[] arr) {
        return Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
    }

    // 3. Reverse the elements of an array
    public static int[] reverseArray(int[] arr) {
        int n = arr.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = arr[n - i - 1];
        }
        return reversed;
    }

    public static int[] reverseArrayJava8(int[] arr) {
        return IntStream.range(0, arr.length).map(i -> arr[arr.length - i - 1]).toArray();
    }

    // 4. Find the sum of all elements in an array
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static int sumArrayJava8(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    // 5. Count the number of even and odd elements in an array
    public static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + ", Odd: " + odd);
    }

    public static void countEvenOddJava8(int[] arr) {
        long even = Arrays.stream(arr).filter(n -> n % 2 == 0).count();
        long odd = arr.length - even;
        System.out.println("Even: " + even + ", Odd: " + odd);
    }

    // 6. Print elements in alternate positions
    public static int[] alternateElements(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            result.add(arr[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] alternateElementsJava8(int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> i % 2 == 0).map(i -> arr[i]).toArray();
    }

    // 7. Find second largest element
    public static int secondLargest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    // 7. Find second largest element
    public static int secondLargestLoop(int[] arr) {

        int first = 0;
        int second = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {

                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] < first) {
                second = arr[i];
            }
        }
        return second;
    }

    // 7. Find second largest element
    public static int thirdLargestLoop(int[] arr) {

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second && arr[i] < first) {
                third = second;
                second = arr[i];
            } else if (arr[i] > third && arr[i] < second) {
                third = arr[i];
            }

        }
        return third;
    }

    public static int findThirdLargest(int[] arr) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException("Array must have at least three elements");
        }

        // Get third largest
        Optional<Integer> i = Arrays.stream(arr)
                .distinct()  // Remove duplicates
                .boxed()
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(2)  // Skip first and second largest
                .findFirst();

        return i.orElse(-1);

    }

    public static int secondLargestJava8(int[] arr) {
        return Arrays.stream(arr).distinct().sorted().toArray()[arr.length - 2];
    }

    // 8. Find second smallest element
    public static int secondSmallest(int[] arr) {
        Arrays.sort(arr);
        return arr[1];
    }

    public static int secondSmallestJava8(int[] arr) {
        return Arrays.stream(arr).distinct().sorted().toArray()[1];
    }

    // 9. Merge two sorted arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        Arrays.sort(merged);
        return merged;
    }

    public static int[] mergeSortedArraysJava8(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    }

    // 10. Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedJava8(int[] arr) {
        return IntStream.range(0, arr.length - 1).allMatch(i -> arr[i] <= arr[i + 1]);
    }

    // 11. Kadane's Algorithm (Largest Sum Contiguous Subarray)
    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static int maxSubarraySumJava8(int[] arr) {
        return Arrays.stream(arr).reduce(arr[0], (max, num) -> Math.max(num, max + num));
    }

    // 12. Left rotate an array by one position
    public static int[] leftRotateByOne(int[] arr) {
        int[] rotated = new int[arr.length];
        System.arraycopy(arr, 1, rotated, 0, arr.length - 1);
        rotated[arr.length - 1] = arr[0];
        return rotated;
    }

    public static int[] leftRotateByOneJava8(int[] arr) {
        return IntStream.concat(Arrays.stream(arr, 1, arr.length), IntStream.of(arr[0])).toArray();
    }

    // 13. Left rotate by k positions
    public static int[] leftRotateByK(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] rotated = new int[n];
        System.arraycopy(arr, k, rotated, 0, n - k);
        System.arraycopy(arr, 0, rotated, n - k, k);
        return rotated;
    }

    public static int[] leftRotateByKJava8(int[] arr, int k) {
        k = k % arr.length;
        return IntStream.concat(Arrays.stream(arr, k, arr.length), Arrays.stream(arr, 0, k)).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 2, 3, 4, 5};
        int[] arr1 = {1, 8, 2, 3, 4, 5};
        // Example calls:
        System.out.println("Max: " + findMax(arr));
        System.out.println("Max (Java 8): " + findMaxJava8(arr));
        System.out.println("Min: " + findMin(arr));
        System.out.println("Min (Java 8): " + findMinJava8(arr));
        System.out.println("Reversed: " + Arrays.toString(reverseArray(arr)));
        System.out.println("Reversed (Java 8): " + Arrays.toString(reverseArrayJava8(arr)));
        System.out.println("Sum: " + sumArray(arr));
        System.out.println("Sum (Java 8): " + sumArrayJava8(arr));
        System.out.println("secondLargest " + secondLargest(arr));
        System.out.println("secondLargestLoop " + secondLargestLoop(arr1));
        System.out.println("thirdLargestLoop " + thirdLargestLoop(arr1));
        System.out.println("thirdLargestStream " + findThirdLargest(arr1));
        countEvenOdd(arr);
        countEvenOddJava8(arr);
    }
}
