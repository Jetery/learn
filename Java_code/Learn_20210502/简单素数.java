import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 给定一个数字n，如果该数乘以7是一个素数，返回"YES"，否则，返回"NO"。
     * @param n int整型 代表题目中的n
     * @return string字符串
     */
    public boolean isPrimer(long n){
        if (n == 1 || n == 2 || n == 3){
            return true;
        }
        if(n%6 != 1 && n%6 != 5){
            return false;
        }
        for(int i = 3;i <= Math.sqrt(n);i+=2){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
    public String solve (int n) {
        // write code here
        if(isPrimer(n * 7)){
            return "YES";
        }
        return "NO";
    }
}