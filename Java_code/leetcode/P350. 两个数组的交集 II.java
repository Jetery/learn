class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] < nums2[j]){
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                list.add(nums1[i++]);
                j++;
            }
        }
        int[] res = new int[list.size()];
        int n = list.size();
        for (int i = 0; i < n; i++){
            res[i] = list.poll();
        }
        return res;
    }
}