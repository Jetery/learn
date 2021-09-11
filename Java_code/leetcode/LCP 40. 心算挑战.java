/*
「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。

示例 1：

    输入：cards = [1,2,8,9], cnt = 3

    输出：18

    解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

示例 2：

    输入：cards = [3,3,1], cnt = 1

    输出：0

    解释：不存在获取有效得分的卡牌方案

*/

class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        int ans = 0;
        // 奇数大根堆
        PriorityQueue<Integer> odd = new PriorityQueue<>((a,b) -> b - a);
        // 偶数大根堆
        PriorityQueue<Integer> help = new PriorityQueue<>((a, b) -> b - a);
        // 分配
        for (int key : cards){
            if (key % 2 == 1){
                odd.add(key);
            } else {
                help.add(key);
            }
        }

        int a = 0;
        int b = 0;
        // 得到cnt - 1 张牌，根据最后结果来决定再摸什么牌
        //（摸cnt张需要考虑更多退还情况，复杂++）
        for (int i = 1; i < cnt; i++){
            if (!odd.isEmpty()) {
                a = odd.poll();
            } else {
                a = 0;
            }
            if (!help.isEmpty()) {
                b = help.poll();
            } else {
                b = 0;
            }
            if (a > b){
                ans += a;
                help.add(b);
            } else {
                ans += b;
                odd.add(a);
            }
        }

        //  还剩最后一张 : 手牌和为奇数则再得到一张奇数  为偶数则再得到一张偶数或者退去一张偶数得到两张奇数
        if (ans % 2 == 1){
             if (!odd.isEmpty() && (odd.peek() != 0)){
                 ans += odd.peek();
            } else {
            	// 无法得到奇数，手牌和无效
                return 0;
            }
        } else {
        	//  摸偶数
            if (!help.isEmpty() && help.peek() != 0){
                ans += help.peek();
            } else {
            	// 两张奇数
                int n = 0;
                // 两张奇数和是否可以等于2
                for (int j = 0; j < 2; j++){
                    if (!odd.isEmpty()){
                        n += odd.poll();
                    } else {
                        break;
                    }
                    if (n == 2){
                        return ans;
                    }
                }
                return 0;
            }
        }
        // 此方法对 cnt == 2 时有缺陷， 如[1, 1, 3, 4, 5, 5, 6, 9, 9, 10] 会得到10 + 16而不是9 + 9
        a = 0;
        if (cnt == 2){
            while (cnt-- > 0){
                if (!odd.isEmpty()){
                    a += odd.poll();
                }
            }
            if (a > ans) return a;
        }
        return ans;
    }
}