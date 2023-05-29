/**
 * LeetCode problem # 1913, 'Maximum Product Difference Between Two Pairs'
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs
 */

import java.util.*;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
    }
}