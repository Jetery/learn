class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        if (len1 < 1) {
            return res;
        }
        
        for (int i = 0; i < len1; i++) {
            int cur = nums1[i];
            int j = 0;
            while (j < len2 && nums2[j] != cur) {
                j++;
            }
            j++;
            while (j < len2 && nums2[j] < cur) {
                j++;
            }
            if (j == len2) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }
}