/**
 * LeetCode problem # 1763, 'Longest Nice Substring'
 * https://leetcode.com/problems/longest-nice-substring
 */

import java.util.*;

class Solution {
    public String longestNiceSubstring(String s) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            set.add(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);
            if (set.contains(Character.toUpperCase(curr)) && set.contains(Character.toLowerCase(curr))) {
                continue;
            }
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i + 1));
            return s1.length() >= s2.length() ? s1 : s2;
        }
        return s;
    }
}
