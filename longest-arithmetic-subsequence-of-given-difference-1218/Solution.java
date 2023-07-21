
/**
 * LeetCode problem # 1218, 'Longest Arithmetic Subsequence of Given Difference'
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */

import java.util.*;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;

        for (int num : arr) {
            int curr = map.getOrDefault(num - difference, 0);
            map.put(num, curr + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}
