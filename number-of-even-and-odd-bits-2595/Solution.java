/*
* LeetCode problem # 2595, Number of Even and Odd Bits
* https://leetcode.com/problems/number-of-even-and-odd-bits
*/

class Solution {
    public int[] evenOddBit(int n) {
        String b = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();

        int even = 0;
        int odd = 0;

        for (int i = 0; i < b.length(); ++i) {
            char c = b.charAt(i);
            if (c == '1') {
                if (i % 2 == 0) {
                    ++even;
                } else {
                    ++odd;
                }
            }
        }
        return new int[] { even, odd };
    }
}
