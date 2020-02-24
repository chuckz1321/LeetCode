package ByteDance;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class LongestNoneDuplicate {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestNoneDuplicate l = new LongestNoneDuplicate();
        l.lengthOfLongestSubstring(s);
    }
}
