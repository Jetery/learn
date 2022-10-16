/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.07.08
 */

import java.util.Scanner;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 时间复杂度小于O(n) ,空间复杂度O(1).
 */

public class FirstDay {
    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            boolean flag = Search(array, num);
            System.out.println(flag);
        }

    }

    //for方法
    public static boolean Search1 (int[][] arrs, int num) {
        int row = arrs[0].length - 1;
        for (int[] ints : arrs) {
            if (ints[row] < num) {
                continue;
            }
            for (int j = 0; j <= row; j++) {
                if (ints[j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    //while方法
    public static boolean Search (int[][] arr, int num) {
        int col = arr.length;
        int row = arr[0].length;
        int i = 0;
        int j = col - 1;
        while (i <= row - 1 && j >= 0) {
            if (arr[i][j] == num) {
                //这个一定要在前面
                //否则下标变动，会在符合前错过要寻找数字
                return true;
            }
            if (arr[i][j] < num) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
