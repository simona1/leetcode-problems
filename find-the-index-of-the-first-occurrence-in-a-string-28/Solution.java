
// LeetCode problem # 28, 'Find the Index of the First Occurrence in a String'
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            boolean found = true;
            for (int j = 0; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
