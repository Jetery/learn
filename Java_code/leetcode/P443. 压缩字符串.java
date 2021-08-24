class Solution {
    public int compress(char[] chars) {
        //待扫描位置
        int i = 0;
        //已处理位置
        int ret = 0;
        int n = chars.length;
        while (i < n) {
            int j = i;
            while (j < n && chars[i] == chars[j]) j++; // j 指向不同处
            int len = j - i;
            chars[ret++] = chars[i];
            if (len > 1) {
                int start = ret, end = start;
                while (len != 0) {
                    chars[end++] = (char)(len % 10 + '0');
                    len /= 10;
                }
                reverse(chars, start, end - 1);
                ret = end;
            }
            i = j;
        }
        return ret;
    }

    private void reverse(char[] cs, int l, int r){
        while (l < r) {
            char temp = cs[l];
            cs[l++] = cs[r];
            cs[r--] = temp;
        }
    }
}