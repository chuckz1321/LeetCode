package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class SortedSquare {
    public int sortedSquares(int[] a) {
        int res = 0;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            if (a[left] == a[right]) {
                res++;
                left++;
                right--;
            } else if (a[left] < a[right]) {
                left++;
                res++;
            } else if (a[left] > a[right]) {
                right--;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SortedSquare().sortedSquares(new int[]{1, 2, 4, 6, 5, 4, 1}));
    }
}
