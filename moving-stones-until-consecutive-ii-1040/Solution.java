
/**
 * LeetCode problem # 1040, 'Moving Stones Until Consecutive II'
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 */

import java.util.*;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);

        int opt1 = stones[n - 1] - stones[1] - n + 2; // move left stone
        int opt2 = stones[n - 2] - stones[0] - n + 2; // move right stone

        int lo = n;
        int hi = Math.max(opt1, opt2);

        int ptr = 0;

        for (int i = 0; i < n; ++i) {
            while (stones[i] - stones[ptr] >= n) {
                ++ptr;
            }
            int df = i - ptr + 1;

            if (df == n - 1 && stones[i] - stones[ptr] == n - 2) {
                lo = Math.min(lo, 2);
            } else {
                lo = Math.min(lo, n - df);

            }
        }
        return new int[] { lo, hi };
    }
}
