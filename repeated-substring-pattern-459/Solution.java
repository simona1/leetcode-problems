/**
 * LeetCode problem # 459, 'Repeated Substring Pattern'
 * https://leetcode.com/problems/repeated-substring-pattern
 */

import java.util.*;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        return sb.toString().indexOf(s, 1) != s.length();
        
    }
}
