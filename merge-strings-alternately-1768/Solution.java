
/**
 * LeetCode problem # 1768, 'Merge Strings Alternately'
 * https://leetcode.com/problems/merge-strings-alternately
 */

class Solution {
    public String mergeAlternately(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder sb = new StringBuilder();
        int shorter = n > m ? m : n;
        for (int i = 0; i < shorter; ++i) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        if (n > m) {
            for (int i = shorter; i < n; ++i) {
                sb.append(a.charAt(i));
            }
        } else if (m > n) {
            for (int i = shorter; i < m; ++i) {
                sb.append(b.charAt(i));
            }
        }
        return sb.toString();
    }
}