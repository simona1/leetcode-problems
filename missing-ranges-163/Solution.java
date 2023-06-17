
/**
 * LeetCode problem # 163, 'Missing Ranges'
 * https://leetcode.com/problems/missing-ranges
 */

import java.util.*;

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        if (nums.length == 0) {
            res.add(Arrays.asList(lower, upper));
            return res;
        }

        if (lower < nums[0]) {
            res.add(Arrays.asList(lower, nums[0] - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= 1) {
                continue;
            }
            res.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
        }

        if (upper > nums[n - 1]) {
            res.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return res;
    }
}