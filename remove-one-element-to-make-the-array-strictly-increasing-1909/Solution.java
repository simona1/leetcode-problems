
/**
 * LeetCode problem # 1909, 'Remove One Element to Make the Array Strictly
 * Increasing'
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            boolean isPossible = true;
            int last = 0;
            for (int j = 0; j < n; ++j) {
                if (j == i) {
                    continue;
                }
                if (last != 0 && nums[j] <= last) {
                    isPossible = false;
                }
                last = nums[j];
            }
            if (isPossible) {
                return true;
            }
        }
        return false;
    }
}
