import java.util.*;


public class Solution {
    /**
     * 
     * @param n long长整型 
     * @return int整型
     */
    public int Numberofoperations (long n) {
        // write code here
        int count = 0;
        while (n>0){
            if (n % 2 == 1){
                n -= 3;
                count++;
            } else {
                n /= 2;
                count++;
            }
        }
        if (n<0){
            return -1;
        }
        return count;
    }
}