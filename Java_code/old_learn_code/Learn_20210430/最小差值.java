import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求最小差值
     * @param a int整型一维数组 数组a
     * @return int整型
     */
    public int minDifference (int[] a) {
        // write code here
        Arrays.sort(a);
        int min = a[a.length -1] -a[a.length-2];
        for (int i = a.length-1;i > 1;i--) {
            for (int j = i-1; j > 0; j--) {
                long temp = a[i] - a[j];
                if (min > temp) {
                    min = (int)temp;
                }
            }
        }
        return min;
    }
}