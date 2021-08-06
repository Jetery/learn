class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                return true;
            }
        }
        return false;
    }
}


class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0, j = 1; j < nums.length; ) {
            if (nums[i] != nums[j]){
                i++;
                j++;
            } else {return true;}
        }
        return false;
    }
}