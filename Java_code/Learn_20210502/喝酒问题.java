import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回牛牛能喝的最多的酒
     * @param m int整型 酒单价
     * @param n int整型 牛牛的现金
     * @return int整型
     */
    public int countWine (int m, int n) {
        // write code here
        //return (n/m)*4-5;//非常神奇
        int sum = n/m;
        int bottle = sum;
        int cap = sum;
        while(cap > 3 || bottle > 1){
            int num = cap/4 + bottle/2;
            sum += num;
            cap = num + cap % 4;
            bottle = num + bottle % 2;
        }
        return sum;
    }
}
