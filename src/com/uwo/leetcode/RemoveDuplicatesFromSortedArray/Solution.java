package com.uwo.leetcode.RemoveDuplicatesFromSortedArray;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0 ;
        for(int num : nums){
            if(i == 0 || num > nums[i-1])
                nums[i++] = num;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = {1,1,3};
        s.removeDuplicates(a);
        
    }
}
