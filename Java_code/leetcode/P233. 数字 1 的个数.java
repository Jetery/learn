class Solution {
    public int countDigitOne(int n) {
        int digit = 1;//位数
        int res = 0;//返回值
        int high = n / 10; //高位
        int low = 0; //低位
        int cur = n % 10;
        while (high != 0 || cur != 0) {
            if (cur == 0){
                res += high * digit;
            }
            else if (cur == 1){
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}