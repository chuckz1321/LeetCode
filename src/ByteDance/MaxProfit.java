package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        // [天数][是否持有股票][已经交易多少次]
        int[][][] dp = new int[length][2][3];
        // 初始化第一天
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][0][2] = 0;
        dp[0][1][2] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0][0] = 0;
            dp[i][1][0] = Integer.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][0][1] = Integer.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][1][1] = Integer.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][0][2] = Integer.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            dp[i][1][2] = dp[i - 1][1][2];
        }
        return Integer.max(dp[length - 1][0][1], dp[length - 1][0][2]);


    }

    public static void main(String[] args) {
        new MaxProfit().maxProfit(new int[]{1, 2, 3, 4, 5});
    }
}
