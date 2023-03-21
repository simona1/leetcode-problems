/**
 * LeetCode problem # 1055, 'Shortest Way to Form String'
 * https://leetcode.com/problems/shortest-way-to-form-string
 */

class Solution {
    public int shortestWay(String source, String target) {
        boolean[] src = new boolean[26];
        for (char c : source.toCharArray()) {
            src[c - 'a'] = true;
        }

        for (char c : target.toCharArray()) {
            if (!src[c - 'a']) {
                return -1;
            }
        }

        String concatenatedSource = source;
        int count = 1;

        while (!isSubsequence(target, concatenatedSource)) {
            concatenatedSource += source;
            ++count;
        }

        return count;
    }

    public boolean isSubsequence(String sub, String seq) {
        int i = 0;
        int j = 0;

        while (i < sub.length() && j < seq.length()) {
            if (sub.charAt(i) == seq.charAt(j)) {
                ++i;
            }
            ++j;
        }

        return i == sub.length();
    }
}
