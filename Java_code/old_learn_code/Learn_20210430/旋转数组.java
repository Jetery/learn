import java.util.*;

public class Solution {
    /**
     * 旋转数组
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public void reverse(int left,int right,int[] a){
        while (left <= right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
    
    public int[] solve (int n, int m, int[] a) {
        // write code here
        m %= n;
        reverse(0,n-m-1,a);
        reverse(n-m,n-1,a);
        reverse(0,n-1,a);
        return a;
    }
}