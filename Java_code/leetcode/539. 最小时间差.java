/*

给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

示例 1：

输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：

输入：timePoints = ["00:00","23:59","00:00"]
输出：0

提示：

2 <= timePoints.length <= 2 * 104
timePoints[i] 格式为 "HH:MM"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-time-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] times = new int[size];
        for (int i = 0; i < size; i++){
            String str = timePoints.get(i);
            int hour = Integer.parseInt(str.substring(0, 2));
            int min = Integer.parseInt(str.substring(3, 5));
            int time = hour * 60 + min;
            //System.out.println(time);
            times[i] = time;
        }
        Arrays.sort(times);
        int min = Math.min(times[1] - times[0], times[0] - times[size - 1] + 24 * 60);
        for (int i = size - 1; i > 0 ; i--){
            min = Math.min(times[i] - times[i - 1], min);
        }
        return min;
    }
}