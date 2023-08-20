/**
 * LeetCode problem # 896, 'Monotonic Array'
 * https://leetcode.com/problems/monotonic-array/
 */

class Solution {
    public boolean isMonotonic(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }

    private boolean isIncreasing(int[] nums) {
        boolean res = true;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > nums[i]) {
                return false;
            }
        }
        return res;
    }

    private boolean isDecreasing(int[] nums) {
        boolean res = true;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] < nums[i]) {
                return false;
            }
        }
        return res;
    }
}