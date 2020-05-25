package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class CutRope {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Integer.max(dp[i], Integer.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
