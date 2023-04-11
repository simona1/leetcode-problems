
/**
 * LeetCode problem # 2390, 'Removing Stars From a String'
 * https://leetcode.com/problems/removing-stars-from-a-string/
 */

import java.util.*;

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c != '*') {
                st.push(c);
            } else {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
}