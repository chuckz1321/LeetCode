package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        sort(nums, 0, nums.length);
    }

    private void sort(int[] nums, int low, int high) {
        int index = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && nums[j] >= index)
                j--;
            if (i < j)
                nums[i++] = nums[j];
            while (i < j && nums[j] < index)
                i++;
            if (i < j)
                nums[j--] = nums[i];
        }
        nums[i] = index;
        sort(nums, low, i - 1);
        sort(nums, i + 1, high);
    }
}
