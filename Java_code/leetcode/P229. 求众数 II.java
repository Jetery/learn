class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            map.put(n, map.getOrDefault(n , 0) + 1);
        }
        int n = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()){
            int times = map.get(key);
            if (times > n){
                list.add(key);
            }
        }
        return list;
    }
}