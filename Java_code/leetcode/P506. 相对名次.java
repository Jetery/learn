/*

给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。

运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：

名次第 1 的运动员获金牌 "Gold Medal" 。
名次第 2 的运动员获银牌 "Silver Medal" 。
名次第 3 的运动员获铜牌 "Bronze Medal" 。
从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。

 

示例 1：

输入：score = [5,4,3,2,1]
输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
示例 2：

输入：score = [10,3,8,9,4]
输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-ranks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for (int i : score){
            queue.add(i);
        }
        String[] ans = new String[score.length];
        int num = 1;
        while (!queue.isEmpty()){
            int val = queue.poll();
            for (int j = 0; j < score.length; j++){
                if (score[j] == val){
                    if (num == 1){
                        ans[j] = "Gold Medal";
                    } else if (num == 2){
                        ans[j] = "Silver Medal";
                    } else if (num == 3){
                        ans[j] = "Bronze Medal";
                    } else {
                        ans[j] = num + "";
                    }
                    num++;
                }
            }
        }
        return ans;
    }
}