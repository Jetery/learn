import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.17
 */
public class RotateArray {

    public static void reverse(int[] arr, int left, int right){
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotate3(int[] arr, int n) {
        if (arr == null || n < 0) {
            throw new IllegalArgumentException("Illeagle Argument!");
        }
        if (n > arr.length) {
            n = n % arr.length;
        }
        reverse(arr,0, arr.length - n - 1);
        reverse(arr, arr.length - n, arr.length - 1);
        reverse(arr, 0 , arr.length - 1);
    }

    public static void rotate2(int[] arr, int n) {
        if (arr == null || n < 0) {
            throw new IllegalArgumentException("Illegal Argument!");
        }
        for (int i = 0; i < n; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    public static void rotate1(int[] arr,int n) {
        if (arr == null || n < 0) {
            throw new IllegalArgumentException("Illeagle Argument!");
        }
        if (n > arr.length) {
            n = n % arr.length;
        }
        int[] copy = new int[arr.length];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[arr.length + i - n];
        }
        for (int i = n; i < arr.length; i++) {
            copy[i] = arr[i - n];
        }
        System.arraycopy(copy,0,arr,0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        rotate3(arr,n);
        System.out.println(Arrays.toString(arr));
    }

}
