class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        TreeSet<String> set = new TreeSet<>();
        //禁止单词加入set中
        Collections.addAll(set, banned);
        //处理字符串
        paragraph = paragraph.replace(","," ").replace("."," ").replace(";"," ").replace("!", " ").replace("?", " ").replace("'"," ");
        String[] strs = paragraph.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for(String s : strs) {
            //转小写
            s = s.toLowerCase();
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s,0) + 1);
                max = Math.max(max, map.get(s));
            }
        }
        for (String s : strs) {
            //转小写
            s = s.toLowerCase();
            if (map.containsKey(s)) {
                if (map.get(s) == max) {
                    return s;
                }
            }
        }
        //banned 为空，paragraph 只有一个单词情况
        return strs[0].toLowerCase();
    }
}