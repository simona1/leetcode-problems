
/**
 * LeetCode problem # 1128, 'Number of Equivalent Domino Pairs'
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int n = dominoes.length;
        int[][] existing = new int[10][10];

        for (int i = n - 1; i >= 0; --i) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];

            if (a != b) {
                res += existing[b][a];
            }
            res += existing[a][b];
            ++existing[a][b];
        }
        return res;
    }
}
