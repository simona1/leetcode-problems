/**
 * LeetCode problem # 1614, 'Maximum Nesting Depth of the Parentheses'
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */

class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                ++count;
                res = Math.max(res, count);
            } else if (c == ')') {
                --count;
            }
        }
        return res;
    }
}
