package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class LongestPalindromicString {
    public String longestPalindrome(String s) {
        int l = s.length();
        if (l < 2) return s;
        int length = 1;
        int start = 0;
        boolean dp[][] = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < l; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {
                    int len = j - i + 1;
                    if (len > length) {
                        length = len;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }
}
