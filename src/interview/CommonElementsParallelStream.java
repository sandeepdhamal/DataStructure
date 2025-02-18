package interview;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CommonElementsParallelStream {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {4, 5, 6, 7, 8, 9};

        // Convert arr2 to a Set for quick lookup
        Set<Integer> set = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        // Find common elements using parallel stream
        List<Integer> commonElements = Arrays.stream(arr1)
                .parallel() // Enable parallel execution
                .filter(set::contains) // Keep only elements that exist in set
                .boxed() // Convert IntStream to Stream<Integer>
                .collect(Collectors.toList());

        System.out.println("Common Elements: " + commonElements);
    }
}
