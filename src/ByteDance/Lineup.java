package ByteDance;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-03
 */
public class Lineup {
    List<List<Integer>> rtn = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> aList= new LinkedList<>();
        backTrace(nums, aList);
        return rtn;
    }

    private void backTrace(int[] nums, LinkedList<Integer> aList) {
        if (aList.size() == nums.length) {
            rtn.add(new LinkedList<>(aList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (aList.contains(nums[i])) {
                continue;
            }
            aList.add(nums[i]);
            backTrace(nums, aList);
            aList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        Lineup l = new Lineup();
        l.permute(num);
    }
}
