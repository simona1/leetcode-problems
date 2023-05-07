
/**
 * LeetCode problem # 1021, 'Remove Outermost Parentheses'
 * https://leetcode.com/problems/remove-outermost-parentheses
 */

class Solution {
    public String removeOuterParentheses(String s) {
        String res = "";
        for (int p1 = 0, p2 = 0, op = 0, cl = 0; p2 < s.length(); ++p2) {
            if (s.charAt(p2) == '(') {
                ++op;
            } else {
                ++cl;
            }
            if (op == cl && p1 < p2) {
                res += s.substring(p1 + 1, p2);
                p1 = p2 + 1;
            }
        }
        return res;
    }
}
