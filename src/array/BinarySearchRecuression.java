package array;

public class BinarySearchRecuression {


    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;
        int low = 0;
        int high = arr.length - 1;
        int found = binarySearch(arr, target, low, high);
        System.out.println(found);


    }

    private static int binarySearch(int[] arr, int target, int low, int high) {


        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {

                return mid;

            }

            if (target <= arr[mid]) {
                return binarySearch(arr, target, low, mid + 1);

            }

            if (target >= arr[mid]) {
                return binarySearch(arr, target, mid - 1, high);

            }
        }

        return -1;
    }
}