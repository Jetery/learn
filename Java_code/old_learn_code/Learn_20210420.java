import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.20
 */
public class Learn_20210420 {

    public static int change(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 != 0) {
                left++;     //获得左边的偶数下标
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;    //获得右边的奇数下标
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        return left;
    }

    public static void exchange(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
    }

    public static void main(String[] args) {
        //给定两个整型数组, 交换两个数组的内容
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        exchange(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void main0(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int ret = change(arr);
        Arrays.sort(arr,0,ret);
        Arrays.sort(arr,ret,arr.length);
        System.out.println(Arrays.toString(arr));
    }

}
