import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int 
     * @param a int一维数组 
     * @return int
     */
    public int search (int n, int[] a) {
        // write code here
        int x = a[0];
        int y = 0;
        for (int i = 1; i <= n;i++){
            x ^= a[i];
            y ^= i;
        }
        return x^y;
    }
}