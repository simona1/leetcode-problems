
/**
 * LeetCode problem # 2578, 'Split With Minimum Sum'
 * https://leetcode.com/problems/split-with-minimum-sum
 */

import java.util.Arrays;

class Solution {
    public int splitNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < chars.length; ++i) {
            if (i % 2 == 0) {
                a.append(chars[i]);
            } else {
                b.append(chars[i]);
            }
        }
        return Integer.parseInt(a.toString()) + Integer.parseInt(b.toString());
    }
}
