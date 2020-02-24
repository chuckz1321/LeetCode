package ByteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                return new int[]{maps.get(nums[i]), i};
            } else {
                maps.put(target - nums[i], i);
            }
        }
        return null;
    }
}
