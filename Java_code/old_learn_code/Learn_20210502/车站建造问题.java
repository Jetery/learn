import java.util.*;


public class Solution {
    /**
     * 
     * @param n int整型 
     * @param a int整型一维数组 
     * @return int整型
     */
    public boolean isPrimer(int n){
        if (n == 1 || n == 2 || n == 3){
            return true;
        }
        if(n%6 != 1 && n%6 != 5){
            return false;
        }
        for(int i = 3;i <= Math.sqrt(n);i+=2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    public int work (int n, int[] a) {
        // write code here
        for(int i = 1; i < a.length; i++){
            if(isPrimer(a[i] - a[i-1])){
                continue;
            } else if ((a[i] - a[i-1])%2 == 0 || isPrimer(a[i] - a[i-1] -2)){
                    n++;
            } else {
                    n+=2;
                }
        }
        return n;
    }
}