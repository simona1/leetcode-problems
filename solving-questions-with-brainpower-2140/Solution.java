/**
 * LeetCode problem # 2140, 'Solving Questions With Brainpower'
 * https://leetcode.com/problems/solving-questions-with-brainpower
 */

class Solution {
    long[] cache;

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        cache = new long[n];

        return solve(0, questions);
    }

    private long solve(int index, int[][] questions) {
        if (index >= questions.length) {
            return 0;
        }
        if (cache[index] != 0) {
            return cache[index];
        }
        long take = questions[index][0] + solve(index + questions[index][1] + 1, questions);
        long skip = solve(index + 1, questions);

        cache[index] = Math.max(take, skip);
        return cache[index];
    }
}
