
/**
 * LeetCode problem # 2741, 'Special Permutations'
 * https://leetcode.com/problems/special-permutations/
 */

import java.util.*;

class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7;

    public int specialPerm(int[] nums) {
        return solve(nums, new Stack<>(), 0, new HashMap<>());
    }

    private int solve(int[] nums, Stack<Integer> st, int used, Map<Integer, Map<Integer, Integer>> cache) {
        if (st.size() == nums.length) {
            return 1;
        }

        Map<Integer, Integer> innerCache = cache.get(used);
        int last = st.isEmpty() ? -1 : st.peek();

        if (innerCache != null) {
            Integer fromCache = innerCache.get(last);
            if (fromCache != null) {
                return fromCache;
            }
        } else {
            cache.put(used, new HashMap<>());
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((used & (1 << i)) != 0) {
                continue;
            }

            if (!st.isEmpty()) {
                if (nums[i] % last != 0 && last % nums[i] != 0) {
                    continue;
                }
            }
            st.push(nums[i]);
            used += (1 << i);

            res += solve(nums, st, used, cache);
            res %= MOD;
            st.pop();
            used -= (1 << i);
        }
        cache.get(used).put(last, res);
        return res;
    }
}