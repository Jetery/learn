/**
 *
 * 在地下室里放着n种颜色的手套，手套分左右手，但是每种颜色的左右手手套个数不一定相同。
 *
 * A 先生现在要出门，所以他要去地下室选手套。但是昏暗的灯光让他无法分辨手套的颜色，只能分辨出左右手。
 *
 * 所以他会多拿一些手套，然后选出一双颜色相同的左右手手套。
 *
 * 现在的问题是，他至少要拿多少只手套(左手加右手)，才能保证一定能选出一双颜色相同的手套。
 *
 * 给定颜色种数n(1 ≤ n ≤ 13),同时给定两个长度为 n 的数组 left,right,分别代表每种颜色左右手手套的数量。
 *
 * 数据保证左右的手套总数均不超过 26，且一定存在至少一种合法方案。
 *
 * 测试样例：
 *
 *      4, [0,7,1,6], [1,5,0,6]
 *
 *      返回
 *      10(解释：可以左手手套取2只，右手手套取8只)
 */
public class Main{
    public static void main(String[] args){
        int[] left = new int[] {0, 7, 1, 6};
        int[] right = new int[] {1,5,0,6};
        findMinimum(4, left, right);
    }
    public static int findMinimum(int n, int[] left, int[] right) {
        // write code here
        int other = 0;
        int leftSum = 0, rightSum = 0;
        int leftMin = Integer.MAX_VALUE, rightMin = leftMin;
        for (int i = 0; i < n; i++){
            if (left[i] * right[i] == 0){
                other += left[i] + right[i];
            } else {
                leftSum += left[i];
                rightSum += right[i];
                leftMin = Math.min(leftMin, left[i]);
                rightMin = Math.min(rightMin, right[i]);
            }
        }
        return other + Math.min(leftSum - leftMin, rightSum - rightMin) + 1 + 1;
    }

}