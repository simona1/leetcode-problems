
/**
 * LeetCode problem # 2760, 'Longest Even Odd Subarray With Threshold'
 * https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/
 */

class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        int left = 1;
        int right = Integer.MAX_VALUE;

        if (nums[0] <= threshold && nums[0] % 2 == 0) {
            right = 0;
        }

        while (left < nums.length) {
            if (nums[left] > threshold || ((nums[left] % 2) == (nums[left - 1] % 2))) {
                res = Math.max(res, left - right);
                right = Integer.MAX_VALUE;
            }

            if (right == Integer.MAX_VALUE && nums[left] <= threshold && nums[left] % 2 == 0) {
                right = left;
            }
            ++left;
        }
        res = Math.max(res, left - right);
        return res;
    }
}