/*

已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数

试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

 

示例 1:

	输入: 1
	输出: [7]


示例 2:

	输入: 2
	输出: [8,4]


示例 3:

	输入: 3
	输出: [8,1,10]

 
提示:

    rand7 已定义。
    传入参数: n 表示 rand10 的调用次数。

*/


// use rand7() more times (cause only use range 1 to 10)
class Solution extends SolBase {
    public int rand10() {
        while(true) {
            int ans = (rand7() - 1) * 7 + rand7() - 1;
            if (ans >= 1 && ans <= 10) {
                return ans;
            }
        }
    }
}


// better way (use range 1 to 40)
class Solution extends SolBase {
    public int rand10() {
        while(true) {
            int ans = (rand7() - 1) * 7 + rand7() - 1;
            if (ans >= 1 && ans <= 40) {
                return ans % 10  + 1;
            }
        }
    }
}