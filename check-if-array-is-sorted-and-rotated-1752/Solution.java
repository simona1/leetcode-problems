
/**
 * LeetCode problem # 1752, 'Check if Array Is Sorted and Rotated'
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated
 */

class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                ++count;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count <= 1 && nums[0] >= nums[n - 1]) {
            return true;
        }
        return false;
    }
}
