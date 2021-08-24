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


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //确保nums1是最短数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int i : nums2) {
            if (map.getOrDefault(i, 0) > 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int n = list.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}