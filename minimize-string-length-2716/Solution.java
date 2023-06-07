
/**
 * LeetCode problem # 2716, 'Minimize String Length'
 * https://leetcode.com/problems/minimize-string-length/
 */

import java.util.*;

class Solution {
    public int minimizedStringLength(String s) {
        Stack<Character> st = new Stack<>();
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
                seen.add(c);
            } else {
                if (st.peek() == c || seen.contains(c)) {
                    continue;
                } else {
                    st.push(c);
                    seen.add(c);
                }
            }
        }
        return st.size();
    }
}
