
/**
 * LeetCode problem # 844, 'Backspace String Compare'
 * https://leetcode.com/problems/backspace-string-compare
 */

import java.util.*;

class Solution {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != '#') {
                ss.push(s.charAt(i));
            } else if (!ss.isEmpty()) {
                ss.pop();
            }
        }

        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) != '#') {
                tt.push(t.charAt(i));
            } else if (!tt.isEmpty()) {
                tt.pop();
            }
        }

        if (ss.size() != tt.size()) {
            return false;
        }

        while (!ss.isEmpty() && !tt.isEmpty()) {
            if (ss.pop() != tt.pop()) {
                return false;
            }
        }
        return true;
    }
}