/**
 * Created with IntelliJ IDEA
 * Description:
 *              假设你有一个数组，其中第  i 个元素是股票在第  i 天的价格。
 *              你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。
 *              请你设计一个算法来计算可以获得的最大收益。
 * User: Jetery
 * Date: 2021.04.27
 */
public class Learn_20210427 {
    public static int maxProfit2 (int[] prices) {
        if (1 == prices.length) {
            return 0;
        }
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy,prices[i]);
            profit = Math.max(profit,prices[i] - buy);
        }
        return profit;
    }

    public static int maxProfit (int[] prices) {
        if (1 == prices.length) {
            return 0;
        }
        int profit = prices[1] - prices[0];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return Math.max(profit, 0);
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,7,8,9,0,4,2};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit2(arr));
    }
}
