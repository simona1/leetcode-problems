
/**
 * LeetCode problem # 1347, 'Minimum Number of Steps to Make Two Strings
 * Anagram'
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 */

class Solution {
    public int minSteps(String s, String t) {
        int[] fr1 = new int[26];
        int[] fr2 = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            fr1[s.charAt(i) - 'a']++;
            fr2[t.charAt(i) - 'a']++;
        }

        int res = 0;

        for (int i = 0; i < 26; ++i) {
            res += Math.abs(fr1[i] - fr2[i]);
        }

        return res / 2;
    }
}
