/**
 * LeetCode problem # 2710, 'Remove Trailing Zeros From a String'
 * https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
 */

class Solution {
    public String removeTrailingZeros(String num) {
        int count = 0;
        int n = num.length();
        for (int i = n - 1; i >= 0; --i) {
            if (num.charAt(i) != '0') {
                break;
            }
            ++count;
        }
        if (n == 1) {
            return num;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - count; ++i) {
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }
}