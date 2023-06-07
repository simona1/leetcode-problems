
/**
 * LeetCode problem # 1493, 'Longest Subarray of 1's After Deleting One Element'
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int zero = 0;
        int res = 0;
        int index = 0;

        for (int i = 0; i < nums.length; ++i) {
            zero += (nums[i] == 0 ? 1 : 0);
            while (zero > 1) {
                zero -= (nums[index] == 0 ? 1 : 0);
                ++index;
            }
            res = Math.max(res, i - index);
        }
        return res;

    }
}
