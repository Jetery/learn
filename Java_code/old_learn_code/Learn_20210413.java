/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.04.13
 */
public class Learn_20210413 {
    
    public static double avg(int[] arr) {
        double sum = 0;
        for (int x : arr) sum += x;
        double ret = sum / arr.length;
        return ret;
    }

    public static int sum(int[] arr) {
        int ret = 0;
        for(int x : arr) ret += x;
        return ret;
    }


    public static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
    }

    public static void assignArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }

    public static void transform(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
    }

    public static void main(String[] args) {
        //实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2
        int[] arr = {1,2,3,4,5,6,7,8};
        transform(arr);
        printArray(arr);
    }

    public static void main4(String[] args) {
        //创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
        int[] arr = new int[100];
        assignArray(arr);
    }

    public static void main3(String[] args) {
        //打印数组
        int[] arr = {1,2,3,4,5,6,7,8};
        printArray(arr);
    }


    public static void main2(String[] args) {
        //实现一个方法 sum, 以数组为参数, 求数组所有元素之和
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(sum(arr));
    }

    public static void main1(String[] args) {
        //实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(avg(arr));
    }
}
