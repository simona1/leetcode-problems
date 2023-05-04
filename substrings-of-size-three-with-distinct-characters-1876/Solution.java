
/**
 * LeetCode problem # 1876, 'Substrings of Size Three with Distinct Characters'
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters
 */

import java.util.*;

class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n - 2; ++i) {

            char[] sub = s.substring(i, i + 3).toCharArray();
            Arrays.sort(sub);

            if (sub[0] != sub[1] && sub[1] != sub[2]) {
                ++res;
            }
        }
        return res;
    }
}
