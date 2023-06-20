
/**
 * LeetCode problem # 1945, 'Sum of Digits of String After Convert'
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 */

import java.util.stream.Collectors;

class Solution {
    public int getLucky(String s, int k) {
        s = s.chars().mapToObj(c -> String.valueOf(c - 96)).collect(Collectors.joining());
        for (int i = 0; i < k; ++i) {
            s = String.valueOf(s.chars().map(c -> c - '0').sum());
        }
        return Integer.valueOf(s);
    }
}