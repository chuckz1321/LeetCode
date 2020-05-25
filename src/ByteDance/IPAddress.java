package ByteDance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-04
 */
public class IPAddress {
    List<String> rtn = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return rtn;
        int splitTime = 0;
        Deque<String> path = new ArrayDeque<>(4);
        backtrace(s, s.length(), 0,  path, splitTime);
        return rtn;
    }

    private void backtrace(String s, int length, int begin, Deque<String> path, int splitTime) {
        // 最终条件
        if (begin == length) {
            if (splitTime == 4) {
                rtn.add(String.join(".", path));
            }
            return;
        }

        //剪枝
        if (length - begin < (4 - splitTime) || length - begin > 3* (4 - splitTime)) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (begin + i >= length) {
                break;
            }
            int ipS = judge(s, begin, begin+i);
            if(ipS != -1) {
                path.add(ipS + "");
                backtrace(s, length, begin+i+1, path, splitTime+1);
                // 回溯
                path.removeLast();
            }
        }

    }

    private int judge(String s, int left, int right) {
        int len = right - left + 1;

        // 大于 1 位的时候，不能以 0 开头
        if (len > 1 && s.charAt(left) == '0') {
            return -1;
        }

        // 转成 int 类型
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }

        if (res > 255) {
            return -1;
        }
        return res;
    }
}
