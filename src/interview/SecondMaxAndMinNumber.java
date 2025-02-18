package interview;

import java.util.Arrays;
import java.util.Optional;

public class SecondMaxAndMinNumber {

    public static void main(String[] args) {
        int arr[] = {1, 2, 5,11,7, 9,56, 10};
        int fmax=arr[0];
        int smax=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>fmax){
                smax=fmax;
                fmax=arr[i];
            }
            else if(arr[i]>smax && smax<fmax){
                smax=arr[i];
            }
        }

        System.out.println( "fmax"+fmax);
        System.out.println( "Smax"+smax);

        Optional<Integer> secondMax = Arrays.stream(arr).distinct().boxed().sorted((a, b) -> b - a).skip(1).findFirst();
        Optional<Integer> secondMin = Arrays.stream(arr).distinct().boxed().sorted().skip(1).findFirst();

        secondMax.ifPresent(integer -> System.out.println("secondMax" + integer));
        secondMin.ifPresent(integer -> System.out.println("Second Min"+ integer));


    }
}
