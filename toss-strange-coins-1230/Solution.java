/**
 * LeetCode problem # 1230, 'Toss Strange Coins'
 * https://leetcode.com/problems/toss-strange-coins
 */

import java.util.*;

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;

        // memo[i][j] - probability of getting j heads with coins from i to n - 1
        double[][] memo = new double[n][target + 1];
        for (double[] row : memo) {
            Arrays.fill(row, - 1);
        }

        return findProbability(0, n, memo, prob, target);
    }


    private double findProbability(int index, int n, double[][] memo, double[] prob, int target) {
        if (target < 0) {
            return 0;
        }

        if (index == n) {
            return target == 0 ? 1 : 0;
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }

        memo[index][target] = findProbability(index + 1, n, memo, prob, target - 1) * prob[index] + findProbability(index + 1, n, memo, prob, target) * (1 - prob[index]);

        return memo[index][target];
    }
}
