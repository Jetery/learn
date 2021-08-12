class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        for(int left = 0, right = 0; right < s.length(); right++) {
            //获得每一个字母出现的次数
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r,0) + 1);

            //出现了重复元素
            while (map.get(r) > 1) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1); // 削减次数
                left++; // 缩小范围
            }
            //刷新长度
            len = Math.max(len, right - left + 1);
        }
        return len;
    }
}

