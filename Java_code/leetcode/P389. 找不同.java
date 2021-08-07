class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        //把所有字母出现次数存入表中
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (map.containsKey(sChar)){
                map.put(sChar, map.get(sChar) + 1);
            } else {
                map.put(sChar, 1);
            }
        }
        for (int i = 0; i < t.length(); i++){
            char temp = t.charAt(i);
            if (map.containsKey(temp)) {
            //含有此字母

                if (map.get(temp) != 0) {
                    //次数减少
                    map.put(temp, map.get(temp) - 1);
                } else {
                    //含有此字母且出现次数削减到0
                    return temp;
                }

            } else {
            //不含有此字母
            //防止上面if空指针异常
                
                if (map.size() == s.length()) {
                    //无重复字母和主字符串出现次数相同
                    //那么此字母必为多余字母
                    return temp;
                }

            }
        }
        return ' ';
    }
}