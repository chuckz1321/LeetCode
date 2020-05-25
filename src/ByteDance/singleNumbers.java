package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-06
 */
public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>(2);
        for (int i : nums) {
            if (list.contains(i)) list.remove(Integer.valueOf(i));
            else list.add(i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        singleNumbers s = new singleNumbers();
        int[] nums = {4,1,4,6};
        s.singleNumbers(nums);
    }
}
