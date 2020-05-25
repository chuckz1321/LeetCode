package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-29
 */
public class MergeRange {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        List<int[]> rtn = new ArrayList<>();
        int[] cur = intervals[0];
        rtn.add(cur);
        for (int[] interval : intervals) {
            int cur_begin = cur[0];
            int cur_end = cur[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            if (cur_end >= next_begin) {
                cur[1] = Math.max(cur_end, next_end);
            } else {
                cur = interval;
                rtn.add(cur);
            }
        }
        return rtn.toArray(new int[rtn.size()][]);
    }
}
