
/**
 * LeetCode problem # 340, 'Longest Substring with At Most K Distinct Characters'
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
 */

import java.util.*;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; ++right) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                ++left;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}