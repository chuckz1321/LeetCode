package ByteDance;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-02-25
 */
public class KthElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

    public static int findKthLargestP(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = right - 1;
            } else {
                return nums[index];
            }
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int pivotIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                pivotIndex++;
                swap(nums, pivotIndex, i);
            }
        }
        swap(nums, left, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6,4,5,1};

    }

}
