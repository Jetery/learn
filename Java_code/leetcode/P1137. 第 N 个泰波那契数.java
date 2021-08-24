//模拟法
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int a = 0, b = 1, c = 1;
        while (n >= 3) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
            n--;
        }
        return c;
    }
}

//记忆化递归
class Solution {
	//记忆化
    int[] rem = new int[40];
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (rem[n] != 0) return rem[n];

        rem[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        
        return rem[n];
    }
}
