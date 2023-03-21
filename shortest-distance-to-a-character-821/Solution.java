
/**
 * LeetCode problem # 821, 'Shortest Distance to a Character'
 * https://leetcode.com/problems/shortest-distance-to-a-character
 */

import java.util.Arrays;

class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        int lastIndex = -1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == c) {
                lastIndex = i;
            }

            if (lastIndex >= 0) {
                res[i] = Math.min(res[i], i - lastIndex);
            }
        }

        lastIndex = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == c) {
                lastIndex = i;
            }

            if (lastIndex >= 0) {
                res[i] = Math.min(res[i], lastIndex - i);
            }
        }

        return res;
    }
}
