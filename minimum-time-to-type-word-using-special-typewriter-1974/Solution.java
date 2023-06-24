
/**
 * LeetCode problem # 1974, 'Minimum Time to Type Word Using Special Typewriter'
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 */

class Solution {
    public int minTimeToType(String word) {
        if (word == null) {
            return 0;
        }

        int last = 0;
        int res = 0;

        for (int i = 0; i < word.length(); ++i) {
            int next = word.charAt(i) - 'a';
            res += 1 + Math.min(Math.abs(next - last), 26 - Math.max(last, next) + Math.min(last, next));
            last = next;
        }
        return res;

    }
}