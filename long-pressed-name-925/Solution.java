/**
 * LeetCode problem # 925, 'Long Pressed Name'
 * https://leetcode.com/problems/long-pressed-name
 */

class Solution {
    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        int n = name.length();
        int t = typed.length();

        char prev = 'A';

        while (i < n && j < t) {
            if (name.charAt(i) == typed.charAt(j)) {
                prev = name.charAt(i);
                ++i;
                ++j;
            } else if (typed.charAt(j) == prev) {
                ++j;
            } else {
                return false;
            }

        }
        if (j < t) {
            prev = typed.charAt(j - 1);

            while (j < t) {
                if (prev != typed.charAt(j++)) {
                    return false;
                }
            }
        }
        return i == n;
    }
}
