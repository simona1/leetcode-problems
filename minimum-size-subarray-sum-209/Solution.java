/**
 * LeetCode problem # 209, 'Minimum Size Subarray Sum'
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            while (sum >= target) {
                res = Math.min(res, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (res != Integer.MAX_VALUE) ? res : 0;

    }
}
