package ByteDance;

import java.util.Arrays;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-23
 */
public class moveStone {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int min = n;
        for (int i = 0, j = 0; j < n; ++j) {
            while (stones[j] - stones[i] + 1 > n) i++;
            int a = j - i + 1;
            if (a == n - 1 && stones[j] - stones[i] + 1 == n - 1) min = Math.min(min, 2);
            else min = Math.min(min, n - a);
        }
        return new int[]{min, Math.max(stones[n - 1] - stones[1] - n + 2, stones[n - 2] - stones[0] - n + 2)};
    }

    public static void main(String[] args) {
        Integer a3 = -1;
        Integer a4 = -1;
        System.out.println(a3 == a4);
        System.out.println(a3 == 150);

    }
}
