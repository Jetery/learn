/*

给定一个长度不小于2的数组arr。 

写一个函数调整arr，使arr中要么所有的偶数位上都是偶数，要么所有的奇数位上都是奇数上。 

要求：
    如果数组长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1),

    下标0,2,4,6…算作偶数位,下标1,3,5,7…算作奇数位，
    
    例如 [1,2,3,4] 调整为 [2,1,4,3] 即可

*/


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            oddInOddEvenInEven(arr);
            System.out.println(Arrays.toString(arr));

        }
    }
    public static void oddInOddEvenInEven(int[] arr) {
        int len = arr.length;
        int i = 0;
        int j = 1;
        while (i < len && j < len){
            //  从最后判断  i j 向前移动
            if (arr[len - 1] % 2 == 0){
                //  最后是偶数, 让 i 的位置是偶数, i 向前
                help(arr, i, len - 1);
                i += 2; 
            } else {
                //  最后是奇数, 让 j 的位置是奇数, j 向前
                help(arr, j, len - 1);
                j += 2;
            }
        }
    }

    private static void help(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


// 未通过  思路相同
//    private static void oddInOddEvenInEven(int[] arr) {
//        int i = 0;
//        int j = 1;
//        while (i < arr.length && j < arr.length){
//            if (arr[i] % 2 == 0){
//                i += 2;
//                continue;
//            }
//            if (arr[j] % 2 != 0){
//                j += 2;
//                continue;
//            }
//            help(arr, i, j);
//        }
//    }
//
//    private static void help(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

}