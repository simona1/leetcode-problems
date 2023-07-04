/**
 * LeetCode problem # 1217, 'Minimum Cost to Move Chips to The Same Position'
 * https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 */

class Solution {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;

        for (int p : position) {
            if (p % 2 == 0) {
                ++even;
            } else {
                ++odd;
            }
        }
        return Math.min(even, odd);
    }
}