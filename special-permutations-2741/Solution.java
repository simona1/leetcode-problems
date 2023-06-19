
/**
 * LeetCode problem # 2741, 'Special Permutations'
 * https://leetcode.com/problems/special-permutations/
 */

import java.util.*;

class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7;

    public int specialPerm(int[] nums) {

        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return solve(nums, -1, 0, cache);
    }

    private int solve(int[] nums, int last, int used, Map<Integer, Map<Integer, Integer>> cache) {
        int n = nums.length;
        if (used + 1 == (1 << n)) {
            return 1;
        }

        Map<Integer, Integer> inner = cache.computeIfAbsent(used, value -> new HashMap<>());
        Integer cached = inner.get(last);
        if (cached != null) {
            return cached;
        }

        int res = 0;
        for (int i = 0; i < n; ++i) {
            if ((used & (1 << i)) != 0) {
                continue;
            }

            if (nums[i] % last != 0 && last % nums[i] != 0) {
                continue;
            }
            res += solve(nums, nums[i], used + (1 << i), cache);
            res %= MOD;
        }

        cache.get(used).put(last, res);
        return res;
    }
}
