/*
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

 

示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 

提示：

    1 <= arr.length <= 10^5
    -100 <= arr[i] <= 100

*/


//  暴力前缀和，超时
class Solution {
    public int maxSubArray(int[] array) {
        int[] arr = new int[array.length + 1];
        for (int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + array[i - 1];
        }
        int ans = arr[1];
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                ans = Math.max(ans, arr[j] - arr[i]);
            }
        }
        return ans;
    }
}

// time: O(2n)
class Solution {
    public int maxSubArray(int[] array) {
        int[] arr = new int[array.length + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + array[i - 1];
        }
        int ans = arr[1];
        for (int i = 0; i < arr.length; i++){
            ans = Math.max(ans, arr[i] - min);
            min = Math.min(arr[i], min);
        }
        return ans;
    }
}

// time: O(n)
class Solution {
    public int maxSubArray(int[] array) {
    	int[] arr = new int[array.length + 1];
    	//  int ans = arr[1];
    	int ans = Integer.MIN_VALUE;
    	int min = arr[1];
    	for (int i = 1; i < arr.length; i++){
    		arr[i] = arr[i - 1] + array[i - 1];
    		ans = Math.max(ans, arr[i] - min);
    		min = Math.min(min, arr[i]);
    	}
    	return ans;
    }
}

