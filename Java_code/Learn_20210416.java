import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.16
 */
public class Learn_20210416 {
    /**
     * 四种拷贝方式
     * 1. use   for
     * 2. copyOf
     * 3. System.arraycopy
     * 4. arr.clone()
     * @param args
     */

    public static void mainCopy4(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = arr.clone();
        System.out.println(Arrays.toString(copy));
    }

    public static void mainCopy3(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = new int[arr.length];
        System.arraycopy(arr,0,copy,0,arr.length);
        System.out.println(Arrays.toString(copy));
    }

    public static void mainCopy2(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(copy));
    }

    public static void mainCopy1(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        System.out.println(Arrays.toString(copy));
    }




    /**
     * homework
     *
     */
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


    public static String myToString(int[] arr) {
        if (arr == null) return "null";
        String ret = "[";
        for (int i = 0; i < arr.length - 1; i++) {
            ret += arr[i];
            ret += ",";
        }
        ret += arr[arr.length - 1];
        return ret + "]";
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null) return false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main5(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,7};
        int[] copy = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(copy));
    }

    public static void main4(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        System.out.println(myToString(arr));
    }

    public static void main3(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        boolean ret = isSorted(arr);
        if (ret) {
            System.out.println("升序");
        } else {
            System.out.println("无序");
        }
    }

    public static void main2(String[] args) {
        int[][]arr={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        for(int row = 0; row < arr.length; row++){
            for(int col = 0; col < arr[row].length; col++){
                System.out.printf("%d\t", arr[row][col]);
            }
            System.out.println();
        }
    }

    public static void main1(String[] args) {
        //Two-point lookup
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int ret = find(arr,2);
        if (ret == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了，下标为：" + ret);
        }
    }
}
