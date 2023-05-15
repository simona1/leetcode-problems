/**
 * LeetCode problem # 2683, 'Neighboring Bitwise XOR'
 * https://leetcode.com/problems/neighboring-bitwise-xor/
 */

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int curr = 0;
        for (int num : derived) {
            curr ^= num;
        }

        return curr == 0;
    }
}