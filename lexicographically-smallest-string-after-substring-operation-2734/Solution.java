
/**
 * LeetCode problem # 2734, 'Lexicographically Smallest String After Substring
 * Operation'
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/
 */

class Solution {
    public String smallestString(String s) {
        int index = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != 'a') {
                index = i;
                break;
            }
        }
        char[] chars = s.toCharArray();
        if (index == -1) {
            chars[s.length() - 1] = 'z';
            return new String(chars);
        }

        for (int i = index; i < s.length(); ++i) {
            if (chars[i] == 'a') {
                break;
            }
            chars[i]--;
        }
        return new String(chars);
    }
}
