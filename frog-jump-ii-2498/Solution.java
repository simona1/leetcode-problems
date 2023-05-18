/**
 * LeetCode problem # 2498, 'Frog Jump II'
 * https://leetcode.com/problems/frog-jump-ii/
 */

class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n <= 2) {
            return stones[n - 1] - stones[0];
        }

        int res = 0;

        for (int i = 2; i < n; ++i) {
            int jump = stones[i] - stones[i - 2];
            res = Math.max(res, jump);
        }
        return res;
    }
}

// jumping more than 2 steps may be sub-optimal
// because we need to return back to 
// the first stone and travel once, and not visit anything more than twice
// so consider alternate stones greedily