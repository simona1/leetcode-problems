
/**
 * LeetCode problem # 2653, 'Sliding Subarray Beauty'
 * https://leetcode.com/problems/sliding-subarray-beauty
 */

import java.util.*;

class Solution {
    private int getKthSmallest(TreeMap<Integer, Integer> tm, int k) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            res += (int) entry.getValue();

            if (res >= k) {
                return Math.min((int) entry.getKey(), 0);
            }
        }
        return 0;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int ptr = 0;
        int index = 0;

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            if (i - ptr + 1 <= k) {
                tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
            } else {
                res[index++] = getKthSmallest(tm, x);

                int curr = nums[ptr];
                int currFreq = tm.getOrDefault(curr, 0);

                if (currFreq <= 1) {
                    tm.remove(curr);
                } else {
                    tm.put(curr, currFreq - 1);
                }

                ++ptr;
                tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
            }
        }
        res[index++] = getKthSmallest(tm, x);
        return res;
    }
}
