/**
 * LeetCode problem # 1180, 'Count Substrings with Only One Distinct Letter'
 * https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
 */

import java.util.*;

class Solution {
    public int countLetters(String s) {
        int n = s.length();
        int curr = 0;
        int res = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != s.charAt(curr)) {
                res += (i - curr) * (i - curr + 1) / 2;
                curr = i;
            }
        }
        res += (n - curr) * (n - curr + 1) / 2;
        return res;
    }
}
