/**
 * LeetCode problem # 389, 'Find the Difference'
 * https://leetcode.com/problems/find-the-difference/
 */

class Solution {
    public char findTheDifference(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); ++i) {
            diff ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            diff ^= t.charAt(i);
        }
        return (char) diff;
    }
}
