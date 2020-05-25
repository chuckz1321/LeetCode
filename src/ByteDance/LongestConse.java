package ByteDance;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class LongestConse {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int length = 0;
        for (int num : nums) {
            if (!num_set.contains(num - 1)) {
                int curNum = num;
                int curLength = 1;
                while (num_set.contains(curNum + 1)) {
                    curNum +=1;
                    curLength +=1;
                }
                length = Integer.max(length, curLength);
            }
        }
        return length;
    }
}
