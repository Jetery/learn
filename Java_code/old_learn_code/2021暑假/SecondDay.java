import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 调整数组中元素的位置，使得奇数位于偶数之前.
 * User: Jetery
 * Date: 2021.07.09
 */
public class SecondDay {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(move(array)));
    }

    public static int[] move(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 1) {
                left++;
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }
}
