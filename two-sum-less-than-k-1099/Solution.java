/**
 * LeetCode problem # 1099, 'Two Sum Less Than K'
 * https://leetcode.com/problems/two-sum-less-than-k/
 */

import java.util.*;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int num : nums) {
            int curr = k - num;
            if (curr < 0) {
                continue;
            } else {
                Integer lower = set.lower(curr);
                if (lower != null) {
                    res = Math.max(res, num + lower);
                }
            }
            set.add(num);
        }
        return res;
    }
}