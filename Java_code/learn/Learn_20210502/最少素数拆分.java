import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 判断给定的正整数最少能表示成多少个素数的和
     * @param N int整型 给定的正整数
     * @return int整型
     */
    public boolean isPrimer(int n){
        if (n == 2 || n == 3){
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
    public int MinPrimeSum (int N) {
        // write code here
        if(isPrimer(N)){
            return 1;
        }
        if(isPrimer(N-2)|| N % 2 ==0){
            return 2;
        }else{
            return 3;
        }
    }
}