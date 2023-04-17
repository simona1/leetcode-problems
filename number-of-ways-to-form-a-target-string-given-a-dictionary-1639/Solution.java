
/**
 * LeetCode problem # 1639, 'Number of Ways to Form a Target String Given a
 * Dictionary'
 * https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/
 */

class Solution {

    static long MOD = (long) Math.pow(10, 9) + 7;

    public int numWays(String[] words, String target) {
        int n = words[0].length();
        int m = target.length();

        long[][] cache = new long[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cache[i][j] = -1;
            }
        }

        int[][] map = new int[n][26];

        for (String w : words) {
            for (int i = 0; i < n; ++i) {
                char c = w.charAt();
                ++map[i][c - 'a'];
            }
  }

        return (int) solve(map, target, 0, 0, cache);
    }
    private long solve(int[][] haystack, String needle, int ih, int in, long[][] cache) {
        if (in == needle.length()) {
            return 1;
        }

        if (ih == haystack.length) {
            return 0;
        }

        if (cache[ih][in] != -1) {
            return cache[ih][in];
        }

        long opt1 = solve(haystack, needle, ih + 1, in, cache);

        int count = haystack[ih][n - 'a'];

        long opt2 = count == 0 ? 0 : count * solve(haystack, needle, ih + 1, in + 1, cache);
        
        return res;
    }

}