package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-03
 */
public class PermuteUnique {
    List<List<Integer>> rtn = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        backtrace(nums, used, list);
        return rtn;
    }

    private void backtrace(int[] nums, boolean[] used, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            rtn.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i >= 1 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backtrace(nums, used, list);
            used[i] = false;
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = {1,1,3};
        PermuteUnique l = new PermuteUnique();
        l.permuteUnique(num);
    }
}
