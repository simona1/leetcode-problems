
/**
 * LeetCode problem # 2220, 'Minimum Bit Flips to Convert Number'
 * https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
 */

class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int res = 0;

        while (num != 0) {
            res += (1 & num);
            num >>= 1;
        }
        return res;
    }
}
