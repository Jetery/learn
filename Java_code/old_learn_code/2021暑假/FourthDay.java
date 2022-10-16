import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.07.11
 */
public class FourthDay {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,7,7,8};
        int key = 5;
        System.out.println(Arrays.toString(find(array,key)));
    }

    public static int[] find (int[] arr, int key) {
        int[] ret = new int[]{-1, -1};
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] == key) {
                ret[0] = left;
                ret[1] = right;
                return ret;
            }
            if (arr[left] + arr[right] > key) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
}
