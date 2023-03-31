/**
 * LeetCode problem # 2057, 'Smallest Index With Equal Value'
 * https://leetcode.com/problems/smallest-index-with-equal-value
 */

class Solution {
    public int smallestEqual(int[] nums) {
        int res = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (i % 10 == nums[i]) {
                res = i;
                break;
            }
        }
        return res;
    }
}