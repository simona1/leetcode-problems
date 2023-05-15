
/**
 * LeetCode problem # 2682, 'Find the Losers of the Circular Game'
 * https://leetcode.com/problems/find-the-losers-of-the-circular-game/
 */

class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] vis = new boolean[n];

        int curr = 0;
        int index = 0;

        while (vis[index % n] == false) {
            ++curr;
            vis[index % n] = true;
            index += curr * k;
        }

        int[] res = new int[n - curr];
        int j = 0;

        for (int i = 0; i < n; ++i) {
            if (vis[i] == false) {
                res[j++] = i + 1;
            }
        }
        return res;
    }
}
