/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.14
 */
public class Learn_20210414 {

    public static int find(int[] arr,int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int ret = find(arr,2);
        if (ret == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了，下标为：" + ret);
        }
    }
}
