class Solution {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            if (nums[i - 1] == 0) {
                sum[i] = sum[i - 1] -1;
            } else {
                sum[i] = sum[i - 1] +1;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(sum[i])) {
                map.put(sum[i], i);
            }
            if (map.containsKey(sum[i])) {
                ret = Math.max(ret, i - map.get(sum[i]));
            }
        }
        return ret;
    }
}