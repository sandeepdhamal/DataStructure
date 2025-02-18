package array;

public class BinarySearchTest {


    public static void main(String[] args) {


        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;
        int found = binarySearch(arr, target);
        System.out.println(found);
        int found1 = binarySearch1(arr, target);
        System.out.println(found1);
        int founds11 = binarySearch11(arr, target);
        System.out.println(founds11);


    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int count = 1;

        while (low <= high) {

            System.out.println("Count - " + count++);
            int mid = low + (high - low) / 2;

            if (target == arr[mid]) {

                return mid;

            }

            if (target < arr[mid]) {

                high = mid - 1;

            }

            if (target > arr[mid]) {
                low = mid + 1;


            }
        }

        return -1;
    }

    public static int binarySearch1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int count = 1;
        while (low <= high) {

            System.out.println("Count - " + count++);
            int mid = low + (high - low) / 2;
// Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }
// If target is greater, ignore the left half
            if (arr[mid] < target) {
                low = mid + 1;
            }
// If target is smaller, ignore the right half
            else {
                high = mid - 1;
            }
        }
// Target not found
        return -1;
    }

    private static int binarySearch11(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int count=1;
        while (low <= high) {

            System.out.println("Count - " + count++);
            int mid = low + (high - low) / 2;


            if (target == arr[mid]) {
                return mid;

            }

            if (target > arr[mid]) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }


        }
        return -1;

    }
}