
/**
 * LeetCode problem # 1403, 'Minimum Subsequence in Non-Increasing Order'
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */

import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int sum = 0;
        int curr = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = nums.length - 1; i >= 0; --i) {
            sum -= nums[i];
            curr += nums[i];
            res.add(nums[i]);

            if (curr > sum) {
                break;
            }
        }
        return res;
    }
}