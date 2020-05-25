package ByteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-09
 */
public class GeneratePa {
    List<String> res = new ArrayList<>();
    int nn = 0;
    public List<String> generateParenthesis(int n) {
        nn = n;
        LinkedList<String> list = new LinkedList<>();
        backtrace(list, n, n, 0);
        return res;
    }

    private void backtrace(LinkedList<String> list, int left, int right, int nopair) {
        if (nopair < 0) {
            return;
        }
        if (list.size() == 2 * nn && left == 0 && right == 0 && nopair == 0) {
            StringBuffer sb = new StringBuffer();
            list.forEach(i -> {
                sb.append(i);
            });
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            list.add("(");
            nopair += 1;
            backtrace(list, left - 1, right, nopair);
            nopair -= 1;
            list.removeLast();
        }
        if (right > 0) {
            list.add(")");
            nopair -= 1;
            backtrace(list, left , right - 1, nopair);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        GeneratePa g = new GeneratePa();
        g.generateParenthesis(3);

    }
}
