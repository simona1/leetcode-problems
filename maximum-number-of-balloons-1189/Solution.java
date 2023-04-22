
/**
 * LeetCode problem # 1189, 'Maximum Number of Balloons'
 * https://leetcode.com/problems/maximum-number-of-balloons/
 */

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] alph = new int[26];

        for (int i = 0; i < text.length(); ++i) {
            ++alph[text.charAt(i) - 'a'];
        }

        int res = 0;

        int a = alph[0];
        int b = alph[1];
        int l = alph[11];
        int o = alph[14];
        int n = alph[13];

        while (a > 0 && b > 0 && n > 0 && l > 1 && o > 1) {
            ++res;
            l -= 2;
            o -= 2;
            --a;
            --b;
            --n;
        }
        return res;
    }
}
