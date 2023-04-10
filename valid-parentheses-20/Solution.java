
/**
 * LeetCode problem # 20, 'Valid Parentheses'
 * https://leetcode.com/problems/valid-parentheses
 */

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put(']', '[');
        parentheses.put('}', '{');
        parentheses.put(')', '(');

        for (int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);
            if (parentheses.containsKey(curr)) {
                if (st.isEmpty()) {
                    return false;
                }
                char last = (char) st.pop();
                char parenthesis = parentheses.get(curr);
                if (last != parenthesis) {
                    return false;
                }
            } else {
                st.push(curr);
            }
        }
        return st.isEmpty();
    }
}
