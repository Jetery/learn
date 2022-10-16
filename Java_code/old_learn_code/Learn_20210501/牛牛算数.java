import java.util.*;


public class Solution {
    /**
     * 
     * @param arr int整型一维数组 
     * @return int整型
     */
    public int Answerofjudge (int[] arr) {
        // write code here
        Arrays.sort(arr);
        double sum = 0;
        double ave = 0;
        if (arr.length%2 == 1) {
            ave = arr[arr.length/2];
        } else {
            ave = arr[arr.length /2-1] + (arr[arr.length/2] - arr[arr.length/2-1])*1.0/2;
        }
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        if (ave > sum*1.0/arr.length) {
            return 1;
        } else if (ave == sum*1.0/arr.length){
            return 0;
        }else {
            return -1;
        }
    }
}