import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * ​请返回Alice能赢的最多局数
     * @param n int 
     * @param p1 int 
     * @param q1 int 
     * @param m1 int 
     * @param p2 int 
     * @param q2 int 
     * @param m2 int 
     * @return int
     */
    public int Mostvictories (int n, int p1, int q1, int m1, int p2, int q2, int m2) {
        // write code here
        int ret = 0;
        ret += Math.min(p1,q2);
        ret += Math.min(q1,m2);
        ret += Math.min(m1,p2);
        return ret;
    }
}