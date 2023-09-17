
/**
 * LeetCode problem # 377, 'Combination Sum IV'
 * https://leetcode.com/problems/combination-sum-iv
 */

import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return comboSumImpl(nums, target, memo);
    }

    private int comboSumImpl(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target == 0) {
            return 1;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int curr = target - nums[i];
            if (curr >= 0) {
                res += comboSumImpl(nums, curr, memo);
            }
        }
        memo.put(target, res);
        return res;
    }

}