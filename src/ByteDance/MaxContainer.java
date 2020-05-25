package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-24
 */
public class MaxContainer {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}

class Solution {
    //计算某个前缀下的数字个数,prefix是前缀，n是全体数的上限
    public long getCurCount(long prefix, int n) {
        long count = 0;
//用下一个前缀的起点减去这个前缀的起点，得到的就是当前前缀下的所有子节点个数
//起点肯定是0，所以每次两者都是*10.比如前缀11的起点是110，他的下一个前缀是12，他的起点是120，
        for (long cur = prefix, next = prefix + 1; cur <= n; cur *= 10, next *= 10) {
                    count += Math.min(n + 1, next) - cur;
        }
        return count;
    }

    //得到了每个前缀下有多少子节点，也就能推断出k在不在当前节点下，如果不在，直接跳到下一个前缀，在就更深入一层，对于字典序来说，深入一层意味着 *10
    public int findKthNumber(int n, int k) {
        //初始前缀，从1开始
        int prefix = 1;
        //当前位置，当curPos =k的时候，此时的前缀拼上该位置的数字就是第k个数字
        int curPos = 1;
        while (curPos < k) {
            //记录该前缀可以组成多少个数字
            long count = getCurCount(prefix, n);
            // k被包括进去了，所以 *10进行深一层的查找
            if (curPos + count > k) {
                prefix *= 10;
                //本质上是一个关于10叉树的前序遍历，curPos++进入到下一个前缀的根节点
                curPos++;
            }
            //k未被包括进去， prefix++，进行右遍的前缀的检查，这里在前缀移动后，curPos自然也不在之前的前缀下了，所以也要跟着移动count个，进去到下个前缀。
            // 当curPos+count==k时，说明k恰好与curPos差距了该前缀下组成数字的个数，所以prefix++,更新curPos，结束循环
            else if (curPos + count <= k) {
                prefix++;
                curPos += count;
            }
        }
        return prefix;
    }
}

