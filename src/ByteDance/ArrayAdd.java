package ByteDance;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-09
 */
public class ArrayAdd {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String str = Arrays.toString(A);
        BigInteger b = new BigInteger(str).add(new BigInteger(String.valueOf(K)));
        String s = b.toString();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            l.add(Integer.parseInt(s.charAt(i) + ""));
        }
        return l;
    }
}
