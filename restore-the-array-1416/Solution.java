
/**
 * LeetCode problem # 1416, 'Restore The Array'
 * https://leetcode.com/problems/restore-the-array
 */

class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7;

    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] cache = new int[n + 1];
        return solve(cache, 0, s, k);
    }

    private int solve(int[] cache, int index, String s, int k) {
        if (cache[index] != 0) {
            return cache[index];
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        long res = 0;
        for (int i = index; i < s.length(); ++i) {
            String curr = s.substring(index, i + 1);
            if (Long.parseLong(curr) > k) {
                break;
            }
            res = (res + solve(cache, i + 1, s, k)) % MOD;
        }
        cache[index] = (int) res;

        return (int) res;
    }
}