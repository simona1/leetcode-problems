/**
 * LeetCode problem # 922, 'Sort Array By Parity II'
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 */

 class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;

        while (i < nums.length && j < nums.length) {
            if (nums[i]% 2 == 0) {
                i += 2;
                continue;
            }
            if (nums[j] % 2 != 0) {
                j += 2;
                continue;
            }
            swap(nums, i, j);
            i += 2;
            j += 2;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
