class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new  int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int elem = nums2[i];
            map.put(elem, i);
        }
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int now = nums1[i];
            int index = map.get(now);
            int j = index;
            for ( ; j < nums2.length; j++) {
                if (nums2[j] > now) {
                    ans[i] = nums2[j];
                    break;
                }
            }
            if (j == nums2.length) ans[i] = -1;

        }
        return ans;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int elem : nums2) {
            while (!stack.isEmpty() && stack.peek() < elem) {
                map.put(stack.pop(), elem);
            }
            stack.push(elem);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++)
            ans[i] = map.getOrDefault(nums1[i], -1);
        return ans;
    }
}