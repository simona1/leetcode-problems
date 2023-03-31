/**
 * LeetCode problem # 1688, 'Count of Matches in Tournament'
 * https://leetcode.com/problems/count-of-matches-in-tournament/
 */

class Solution {
    // proof of de facto solution
    public int numberOfMatches(int n) {
        int teams = n;
        int matches = 0;

        while (teams != 1) {
            matches += teams / 2;
            teams -= teams / 2;
        }
        return matches;
    }

    // de facto solution
    public int numMatches(int n) {
        return n - 1;
    }
}