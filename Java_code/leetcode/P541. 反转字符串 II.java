class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int index = 1;
        int n = s.length();
        int step = 2 * k;
        for( ; index <= n; index++) {
            if (index % step == 0) {
                reverse(ch, index - step, index - k -1);
            }
        }
        //index 跳出循环为 n + 1
        index--;
        int left = n % step;
        if (left > k) {
            reverse(ch, index - left, index - left%k - 1);
        } else {
            reverse(ch, index - left, index -1);
        }
        return String.valueOf(ch);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}


//优化index的步长
//优化跳出循环的判断
class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int kk  = 2 * k;
        //反转的起点为 0  2k  4k ...
        for(int index = 0; index < n; index = index + kk) {
            //起点之后k个, 为了取下标 : -1
            int end = index + k - 1;

            //Math.min(end,n - 1)确保不越界
            reverse(chars, index, Math.min(end,n - 1));
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}
