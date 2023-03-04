/*
 * LeetCode problem # 2444, 'Count Subarrays With Fixed Bounds'
 * https://leetcode.com/problems/count-subarrays-with-fixed-bounds
 */

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        long leftBound = -1;
        long minIndex = -1;
        long maxIndex = -1;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                minIndex = maxIndex = -1;
                leftBound = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            res += Math.max(0, Math.min(minIndex, maxIndex) - leftBound);
        }
        return res;
    }
}
