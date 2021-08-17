
// 一次遍历法
class Solution {
    public boolean checkRecord(String s) {
        if(s == null) return true;
        int A = 0;
        int L = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                A++;
                L = 0;
                if (A == 2) return false;
            } else if (c == 'L') {
                L++;
                if (L == 3) return false;
            } else {
                L = 0;
            }
        }
        return true;
    }
}



// 使用库函数法
// 缺勤都在同一天，并且不含有三天连续L（迟到）
class Solution {
    public boolean checkRecord(String s) {
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }
}